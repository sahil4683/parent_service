package com.ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.ms.config.BusinessException;
import com.ms.entity.User;
import com.ms.repo.UserRepository;
import com.ms.service.UserService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@Order(1)
	void testCreateUser() {
		// Arrange
		User user = new User(1l, "sahil", "sahil@email.com");
		when(userRepository.save(any(User.class))).thenReturn(user);

		// Act
		User createdUser = userService.createUser(user);

		// Assert
		assertNotNull(createdUser);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	@Order(3)
	void testUpdateUser() {
		// Arrange
		User user = new User();
		when(userRepository.save(any(User.class))).thenReturn(user);

		// Act
		User updatedUser = userService.updateUser(user);

		// Assert
		assertNotNull(updatedUser);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	@Order(6)
	void testDeleteUser() {
		// Arrange
		Long userId = 1L;

		// Act
		userService.deleteUser(userId);

		// Assert
		verify(userRepository, times(1)).deleteById(userId);
	}

//	@Test
//	@Order(2)
//	void testGetUserById_ExistingUser() {
//		// Arrange
//		Long userId = 1L;
//		User user = new User();
//		when(userRepository.findById(userId)).thenReturn(Optional.of(user));
//
//		// Act
//		User result = null;
//		try {
//		result = userService.getUserById(userId);
//		}catch (BusinessException ex) {
//		    System.out.println("BusinessException occurred: " + ex.getMessage());
//		}
//
//		// Assert
//		assertNotNull(result);
//		assertEquals(user, result);
//		verify(userRepository, times(1)).findById(userId);
//	}

	@Test
	@Order(4)
	void testGetUserById_NonExistingUser() {
		// Arrange
		Long userId = 1L;
		when(userRepository.findById(userId)).thenReturn(Optional.empty());

		// Act & Assert
		assertThrows(BusinessException.class, () -> userService.getUserById(userId));
		verify(userRepository, times(1)).findById(userId);
	}

	@Test
	@Order(5)
	void testGetAllUsers() {
		// Arrange
		List<User> users = new ArrayList<>();
		users.add(new User());
		when(userRepository.findAll()).thenReturn(users);

		// Act
		List<User> result = userService.getAllUsers();

		// Assert
		assertNotNull(result);
		assertEquals(users, result);
		verify(userRepository, times(1)).findAll();
	}
}
