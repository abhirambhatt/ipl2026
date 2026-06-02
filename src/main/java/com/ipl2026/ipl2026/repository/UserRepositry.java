package com.ipl2026.ipl2026.repository;

import com.ipl2026.ipl2026.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
