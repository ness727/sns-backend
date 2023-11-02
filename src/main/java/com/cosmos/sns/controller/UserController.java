package com.cosmos.sns.controller;

import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String addUser(@Valid @ModelAttribute("user") AddUserRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("유저 등록 error");
            return "/signup";
        }
        System.out.println("UserController.addUser");
        userService.save(user);

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest userDto, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(userDto, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
