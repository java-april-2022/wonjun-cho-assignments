package com.codingdojo.bookclub.service;

import com.codingdojo.bookclub.model.LoginUser;
import com.codingdojo.bookclub.model.User;
import com.codingdojo.bookclub.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User newUser, BindingResult result) {
        if (userRepository.findByEmail(newUser.getEmail()).isPresent())
            result.rejectValue("email", "email", "Email is already in use");

        if (!newUser.getPassword().equals(newUser.getConfirm()))
            result.rejectValue("confirm", "confirm", "Confirm password should match");

        if (result.hasErrors()) return null;

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);

        return userRepository.save(newUser);
    }

    public User login(LoginUser loginUser, BindingResult result) {
        Optional<User> foundUser = userRepository.findByEmail(loginUser.getEmail());

        if (!foundUser.isPresent()) {
            result.rejectValue("email", "email", "Incorrect Email");
        }

        if (result.hasErrors()) return null;

        if (!BCrypt.checkpw(loginUser.getPassword(), foundUser.get().getPassword()))
            result.rejectValue("password", "password", "Incorrect Password");

        if (result.hasErrors()) return null; // used same statement twice to display correct messages in every case

        return foundUser.get();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
