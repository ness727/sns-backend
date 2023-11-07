package com.cosmos.sns.dto;

import com.cosmos.sns.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddUserRequest {
    @NotBlank(message = "이메일을 입력해주세요")
    @Size(max = 50, message = "50자 이내로 입력해주세요")
    @Pattern(regexp = "([\\w+.-]+@[\\w+-]+\\.[\\w+.-]+)*", message = "이메일 형식으로 입력해 주세요")  // 영문자, 숫자, 밑줄만 가능
    //@Email(message = "이메일 형식으로 입력해 주세요")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(max = 20, message = "20자 이내로 입력해주세요")
    @Pattern(regexp = "[\\w!@#+=%^*-]*", message = "사용할 수 없는 문자가 포함되어 있습니다.")
    // 영문자, 일부 특수기호, 숫자, 밑줄만 가능
    private String pwd;

    @NotBlank(message = "이름를 입력해주세요")
    @Size(max = 30, message = "30자 이내로 입력해주세요")
    @Pattern(regexp = "[가-힣a-zA-Z]*", message = "사용할 수 없는 문자가 포함되어 있습니다.")  // 한글, 영문 이름만 가능
    private String userName;

    @NotBlank(message = "별명을 입력해주세요")
    @Size(max = 20, message = "20자 이내로 입력해주세요")
    private String nickname;

    @NotBlank(message = "핸드폰 번호를 입력해주세요")
    @Size(max = 15)
    private String phone;

    private String profileImage;
    private int status;

    public User toEntity() {
        return User.builder()
                .email(email)
                .pwd(pwd)
                .userName(userName)
                .nickname(nickname)
                .phone(phone)
                .profileImage(profileImage)
                .status(status)
                .build();
    }
}
