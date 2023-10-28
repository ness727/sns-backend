package com.cosmos.sns.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pwd", nullable = false)
    private String pwd;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "status", nullable = false)
    private int status;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public User(Long id, String email, String pwd, String userName, String nickname, String phone, String profileImage, int status, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.userName = userName;
        this.nickname = nickname;
        this.phone = phone;
        this.profileImage = profileImage;
        this.status = status;
        this.createdAt = createdAt;
    }
}
