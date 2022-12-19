package com.example.max.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.max.exeption.UserNotFoundException;
import com.example.max.model.User;
import com.example.max.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public User findById(Long id) {
		return userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("user not find by id : " + id));
	}

	public User updateUser(Long id, User user) {
		User dateUser = userRepo.findById(id).get();
		if(dateUser != null) {
			dateUser.setFirstName(user.getFirstName());
			dateUser.setFirstName(user.getFirstName());
			dateUser.setAge(user.getAge());
			dateUser.setEmail(user.getEmail());
			dateUser.setMobile(user.getMobile());
			userRepo.save(dateUser);
		}
		return dateUser;
	}

	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
	}
}
