package com.cosmos.sns.controller;

import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public String addUser(@Valid @ModelAttribute("user") AddUserRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("유저 등록 error");
            return "/signup";
        }
        userService.save(user);

        return "redirect:/login";
    }

}
