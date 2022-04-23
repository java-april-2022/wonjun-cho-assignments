package com.codingdojo.omikuji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index () {
        return "redirect:/omikuji";
    }
    @GetMapping("/omikuji")
    public String omikuji () {
        return "index.jsp";
    }
    @PostMapping("/processForm")
    public String processForm (@RequestParam String number, @RequestParam String city, @RequestParam String name,
                          @RequestParam String hobby, @RequestParam String livingThing, @RequestParam String compliment, HttpSession session) {
        String result = String.format("In %s years, you will live in %s with %s as your roomate, %s for a living. The next time you see %s, you" +
                " will have good luck. Also, %s", number, city, name, hobby, livingThing, compliment);
        session.setAttribute("result", result);
        return "redirect:/omikuji/show";
    }
    @GetMapping("/omikuji/show")
    public String show (HttpSession session, Model model) {
        String result = (String) session.getAttribute("result");
        model.addAttribute("result", result);
        return "result.jsp";
    }
}
