package com.cosmos.sns.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
@Table(name = "Users")
public class User extends CreatedDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = 20)
    private String email;

    @Column(name = "pwd", nullable = false, length = 20)
    private String pwd;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "nickname", nullable = false, length = 20)
    private String nickname;

    @Column(name = "phone", nullable = false, length = 13)
    private String phone;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "status", nullable = false)
    private int status;

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
