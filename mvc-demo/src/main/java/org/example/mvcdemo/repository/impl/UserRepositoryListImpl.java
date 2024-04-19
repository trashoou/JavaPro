package org.example.mvcdemo.repository.impl;

import org.example.mvcdemo.model.User;
import org.example.mvcdemo.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryListImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
