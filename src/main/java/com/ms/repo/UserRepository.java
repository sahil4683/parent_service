package com.ms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
