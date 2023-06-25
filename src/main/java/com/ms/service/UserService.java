package com.ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ms.config.BusinessException;
import com.ms.config.NotFoundException;
import com.ms.entity.User;
import com.ms.repo.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> 
                
//                new NotFoundException("User not found")
                new BusinessException("Invalid condition encountered")
                		
                		);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
