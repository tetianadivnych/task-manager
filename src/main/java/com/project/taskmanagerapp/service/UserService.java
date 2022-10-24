package com.project.taskmanagerapp.service;

import com.project.taskmanagerapp.exception.CustomEntityNotFoundException;
import com.project.taskmanagerapp.model.User;
import com.project.taskmanagerapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new CustomEntityNotFoundException("User with id: " + userId + " not found"));
    }

}
