package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User insertUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
