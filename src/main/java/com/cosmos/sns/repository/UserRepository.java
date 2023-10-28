package com.cosmos.sns.repository;

import com.cosmos.sns.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
