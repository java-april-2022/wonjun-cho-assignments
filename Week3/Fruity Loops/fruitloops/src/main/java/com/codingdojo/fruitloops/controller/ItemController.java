package com.codingdojo.fruitloops.controller;

import com.codingdojo.fruitloops.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class ItemController {
    @RequestMapping("")
    public String index (Model model) {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("Kiwi", 1.5));
        list.add(new Item("Mango", 2.0));
        list.add(new Item("Goji Berries", 4.0));
        list.add(new Item("Guava", .75));

        model.addAttribute("fruitList", list);

        return "index.jsp";
    }
}
