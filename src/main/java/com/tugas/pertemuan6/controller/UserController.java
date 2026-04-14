package com.tugas.pertemuan6.controller;

import com.tugas.pertemuan6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> userList = new ArrayList<>();

    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140179";

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if ((username.equals(USERNAME) && password.equals(PASSWORD))) {
            return "redirect:/home"; // Redirect ke mapping /home
        } else {
            model.addAttribute("error", "Username atau Password salah");
        }
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(User user) {
        userList.add(user);
        return "redirect:/home";
    }
}
