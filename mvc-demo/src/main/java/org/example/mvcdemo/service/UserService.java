package org.example.mvcdemo.service;

import org.example.mvcdemo.model.User;

import java.util.List;

public interface UserService {

    User addUser(String firstName, String lastName, String email, String password);

    List<User> getAllUsers();
}
