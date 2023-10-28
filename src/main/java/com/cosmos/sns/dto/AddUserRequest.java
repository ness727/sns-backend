package com.cosmos.sns.dto;

import com.cosmos.sns.domain.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private String email;
    private String pwd;
    private String userName;
    private String nickname;
    private String phone;
    private String profileImage;
    private int status;
    private LocalDateTime createdAt;

    public User toEntity() {
        return User.builder()
                .email(email)
                .pwd(pwd)
                .userName(userName)
                .nickname(nickname)
                .phone(phone)
                .profileImage(profileImage)
                .status(status)
                .createdAt(createdAt)
                .build();
    }
}
