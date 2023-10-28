package com.cosmos.sns.service;

import com.cosmos.sns.domain.User;
import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User save(AddUserRequest request) {
        return userRepository.save(request.toEntity());
    }
}
