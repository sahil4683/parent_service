package com.ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ms.entity.User;
import com.ms.rest.UserController;
import com.ms.service.UserService;

class UserControllerTest {
	@Mock
	private UserService userService;

	@InjectMocks
	private UserController userController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	static User user;

	@BeforeAll
	static void setupUser() {
		user = new User(1l, "sahil", "sahil@email.com");
	}

	@Test
	void testCreateUser() {
		// Arrange
		when(userService.createUser(any(User.class))).thenReturn(user);
		// Act
		ResponseEntity<User> responseEntity = userController.createUser(user);
		// Assert
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(user, responseEntity.getBody());
		verify(userService, times(1)).createUser(user);
	}

	@Test
	void testUpdateUser() {
		// Arrange
		Long userId = 1L;
		when(userService.updateUser(any(User.class))).thenReturn(user);

		// Act
		ResponseEntity<User> responseEntity = userController.updateUser(userId, user);

		// Assert
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(user, responseEntity.getBody());
		verify(userService, times(1)).updateUser(user);
	}

	@Test
	void testDeleteUser() {
		// Arrange
		Long userId = 1L;

		// Act
		ResponseEntity<Void> responseEntity = userController.deleteUser(userId);

		// Assert
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
		verify(userService, times(1)).deleteUser(userId);
	}

	@Test
	void testGetUserById() {
		// Arrange
		Long userId = 1L;
		when(userService.getUserById(userId)).thenReturn(user);

		// Act
		ResponseEntity<User> responseEntity = userController.getUserById(userId);

		// Assert
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(user, responseEntity.getBody());
		verify(userService, times(1)).getUserById(userId);
	}

	@Test
	void testGetAllUsers() {
		// Arrange
		List<User> users = new ArrayList<>();
		users.add(new User());
		when(userService.getAllUsers()).thenReturn(users);

		// Act
		ResponseEntity<List<User>> responseEntity = userController.getAllUsers();

		// Assert
		assertNotNull(responseEntity);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(users, responseEntity.getBody());
		verify(userService, times(1)).getAllUsers();
	}
}
