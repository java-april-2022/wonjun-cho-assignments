package com.codingdojo.dojoandninja.controller;

import com.codingdojo.dojoandninja.model.Dojo;
import com.codingdojo.dojoandninja.service.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DojoController {

    @Autowired
    private DojoService service;

    @GetMapping("/dojos/new")
    public String createDojoForm(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo.jsp";
    }

    @GetMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dojo", service.findDojoById(id));
        return "show.jsp";
    }

    @PostMapping("/dojos/new/create")
    public String processForm(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        }
        service.createDojo(dojo);
        return "redirect:/ninjas/new";
    }
}
