package com.cosmos.sns.controller;

import com.cosmos.sns.domain.User;
import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        userRepository.deleteAll();
    }
/*
    @DisplayName("addUser - 유저 추가 성공")
    @Test
    public void addUser() throws Exception {
        // given
        final String url = "/users";
        final String email = "hello@afdsfs.com";
        final String pwd = "1234";
        final String userName = "Kim";
        final String nickname = "hihi";
        final String phone = "01012344321";
        final String profileImage = null;
        final int status = 1;
        final LocalDateTime createdAt = null;

        final AddUserRequest userRequest
                = new AddUserRequest(email, pwd, userName, nickname, phone, profileImage, status);

        // 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        // when
        // 요청 전송
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());

        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
        assertThat(users.get(0).getEmail()).isEqualTo(email);
        assertThat(users.get(0).getPwd()).isEqualTo(pwd);
    }
    */
}