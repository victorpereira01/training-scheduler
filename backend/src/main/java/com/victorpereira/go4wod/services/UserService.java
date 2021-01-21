package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    User findById(Long id);

    User insertUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
