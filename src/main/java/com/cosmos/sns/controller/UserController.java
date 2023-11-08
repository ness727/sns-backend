package com.cosmos.sns.controller;

import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public String addUser(@Valid @ModelAttribute("user") AddUserRequest user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.debug("유저 등록 error");
            return "/signup";
        }
        try {
            userService.save(user);
        }
        catch (DataIntegrityViolationException e) {
            log.error("중복 이메일 발견으로 유저 가입 실패");
        }

        return "redirect:/login";
    }

    @GetMapping("/id-check/{userEmail}")
    public String checkUserId(@PathVariable String userEmail, Model model) {
        boolean result = false;

        if(userService.checkIsDuplicatedUserEmail(userEmail)) {
            result = true;
        }
        model.addAttribute("isDuplicated", result);
        return "/signup";
    }
}
