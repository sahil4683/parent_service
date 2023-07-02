package com.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.config.BusinessException;
import com.ms.entity.User;
import com.ms.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		log.info("User : {}",user);
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() ->
//                new NotFoundException("User not found")
		new BusinessException("Invalid condition encountered")

		);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
