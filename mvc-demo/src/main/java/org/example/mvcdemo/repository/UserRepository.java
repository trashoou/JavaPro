package org.example.mvcdemo.repository;

import org.example.mvcdemo.model.User;

public interface UserRepository extends CrudRepository<User> {

    //User findByEmail(String email);
}
