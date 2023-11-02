package com.cosmos.sns.controller;

import com.cosmos.sns.dto.AddUserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(AddUserRequest userDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            System.out.println("가입 실패");
        }
        else model.addAttribute("user", new AddUserRequest());
        System.out.println("UserViewController.signup");
        return "signup";
    }
}
