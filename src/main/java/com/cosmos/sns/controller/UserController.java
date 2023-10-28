package com.cosmos.sns.controller;

import com.cosmos.sns.domain.User;
import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) {
        User user = userService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
