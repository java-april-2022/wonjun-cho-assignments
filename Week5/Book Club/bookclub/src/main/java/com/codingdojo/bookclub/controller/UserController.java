package com.codingdojo.bookclub.controller;

import com.codingdojo.bookclub.model.LoginUser;
import com.codingdojo.bookclub.model.User;
import com.codingdojo.bookclub.service.UserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("loginUser", new LoginUser());
        return "home.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        User user = userService.register(newUser, result);

        if (user == null || result.hasErrors()) {
            model.addAttribute("loginUser", new LoginUser());
            return "home.jsp";
        }
        session.setAttribute("user", user.getId());

        return "redirect:/books";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
        User user = userService.login(loginUser, result);

        if (user == null || result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "home.jsp";
        }
        session.setAttribute("user", user.getId());

        return "redirect:/books";
    }

}
