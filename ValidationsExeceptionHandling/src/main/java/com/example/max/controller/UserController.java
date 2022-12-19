package com.example.max.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.max.model.User;
import com.example.max.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(
			@PathVariable("id") Long id, @RequestBody User user) {
		return new ResponseEntity<>(
				userService.updateUser(id, user), HttpStatus.UPGRADE_REQUIRED);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
 }
