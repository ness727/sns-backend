package com.cosmos.sns.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @Column(name = "email", nullable = false)
    @NotBlank(message = "이메일을 입력해주세요")
    @Size(min = 1, max = 50, message = "50자 이내로 입력해주세요")
    @Pattern(regexp = "[\\w+.-]+@[\\w+-]+.[\\w+.-]+", message = "이메일 형식으로 입력해 주세요")  // 영문자, 숫자, 밑줄만 가능
    private String email;

    @Column(name = "pwd", nullable = false)
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 1, max = 20, message = "20자 이내로 입력해주세요")
    @Pattern(regexp = "[\\w0-9!@#+=%^*-]+", message = "사용할 수 없는 문자가 포함되어 있습니다.")
        // 영문자, 일부 특수기호, 숫자, 밑줄만 가능
    private String pwd;

    @Column(name = "user_name", nullable = false)
    @NotBlank(message = "이름를 입력해주세요")
    @Size(min = 1, max = 30, message = "30자 이내로 입력해주세요")
    @Pattern(regexp = "[가-힣a-zA-Z]+", message = "사용할 수 없는 문자가 포함되어 있습니다.")  // 한글, 영문 이름만 가능
    private String userName;

    @Column(name = "nickname", nullable = false)
    @NotBlank(message = "별명을 입력해주세요")
    @Size(min = 1, max = 20, message = "20자 이내로 입력해주세요")
    private String nickname;

    @Column(name = "phone", nullable = false)
    @NotBlank(message = "핸드폰 번호를 입력해주세요")
    @Size(min = 1, max = 13)
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
