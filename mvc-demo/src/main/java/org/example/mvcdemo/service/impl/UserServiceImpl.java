package org.example.mvcdemo.service.impl;

import org.example.mvcdemo.model.User;
import org.example.mvcdemo.repository.UserRepository;
import org.example.mvcdemo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(String firstName, String lastName, String email, String password) {
        User user = new User(firstName, lastName, email, password);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(); // запрашиваем у репозитортия
    }
}
