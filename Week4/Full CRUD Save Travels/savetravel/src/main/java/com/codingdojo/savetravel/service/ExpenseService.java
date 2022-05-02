package com.codingdojo.savetravel.service;

import com.codingdojo.savetravel.model.Expense;
import com.codingdojo.savetravel.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    public List<Expense> all() {
        return repo.findAll();
    }

    public Expense create(Expense e) {
        return repo.save(e);
    }

    public Expense update(Expense e) {
        return repo.save(e);
    }

    public Expense find(Long id) {
        Optional<Expense> optional = repo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
