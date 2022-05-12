package com.codingdojo.bookclub.controller;

import com.codingdojo.bookclub.model.Book;
import com.codingdojo.bookclub.service.BookService;
import com.codingdojo.bookclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String welcome(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("currentUser", userService.findById((Long) session.getAttribute("user")));
            model.addAttribute("books", bookService.findAll());

            return "welcome.jsp";
        }
        System.out.println("test");
        return "redirect:/";
    }

    @GetMapping("/new")
    public String createBookForm(@ModelAttribute("newBook") Book newBook, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/";
        return "newBook.jsp";
    }

    @PostMapping("/new/create")
    public String createBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session) {
        if (result.hasErrors()) return "newBook.jsp";

        newBook.setUser(userService.findById((Long) session.getAttribute("user")));
        bookService.addOrUpdateBook(newBook);

        return "redirect:/books";
    }

    @GetMapping("{id}")
    public String detail(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/";
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("currentUser", (Long) session.getAttribute("user"));

        return "detail.jsp";
    }

    @GetMapping("{id}/edit")
    public String edit(@ModelAttribute("editBook") Book book, @PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) return "redirect:/";
        model.addAttribute("editBook", bookService.findById(id));

        return "edit.jsp";
    }

    @PutMapping("/edit/process")
    public String updateBook(@Valid @ModelAttribute("editBook") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }

        bookService.addOrUpdateBook(book);
        return "redirect:/books";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/";
    }
}
