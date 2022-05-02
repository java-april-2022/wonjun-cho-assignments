package com.codingdojo.savetravel.controller;

import com.codingdojo.savetravel.model.Expense;
import com.codingdojo.savetravel.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ExpenseService service;

    @GetMapping("/")
    public String index() {
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
        model.addAttribute("expenses", service.all());

        return "index.jsp";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", service.find(id));
        model.addAttribute("expenses", service.all());

        return "edit.jsp";
    }

    @GetMapping("/expenses/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("expense", service.find(id));

        return "detail.jsp";
    }

    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("expenses", service.all());
            return "index.jsp";
        }
        service.create(expense);

        return "redirect:/expenses";
    }

    @PutMapping("/expenses/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("expenses", service.all());
            return "edit.jsp";
        }
        service.update(expense);

        return "redirect:/expenses";
    }

    @DeleteMapping("/expenses/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete(id);

        return "redirect:/expenses";
    }
}
