package com.codingdojo.dojoandninja.controller;

import com.codingdojo.dojoandninja.model.Dojo;
import com.codingdojo.dojoandninja.model.Ninja;
import com.codingdojo.dojoandninja.service.DojoService;
import com.codingdojo.dojoandninja.service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;
    @Autowired
    private DojoService dojoService;

    @GetMapping("/ninjas/new")
    public String createNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoService.allDojo());
        return "newNinja.jsp";
    }

    @PostMapping("/ninjas/new/create")
    public String processForm(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dojos", dojoService.allDojo());
            return "newNinja.jsp";
        }
        ninjaService.createNinja(ninja);
        return String.format("redirect:/dojos/%d", ninja.getDojo().getId());
    }
}
