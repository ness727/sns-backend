package com.cosmos.sns.service;

import com.cosmos.sns.domain.User;
import com.cosmos.sns.dto.AddUserRequest;
import com.cosmos.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) throws DataIntegrityViolationException {
        if (userRepository.findByEmail(dto.getEmail()) != null) {
            throw new DataIntegrityViolationException("중복 아이디 발견");
        }

        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        return userRepository.save(dto.toEntity()).getId();
    }

    public boolean checkIsDuplicatedUserEmail(String Email) {
        if (userRepository.findByEmail(Email) != null) {
            return true;
        }
        else return false;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return user;
    }
}
