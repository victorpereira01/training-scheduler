package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserNewDTO findById(Long id);

    UserNewDTO insertUser(UserNewDTO user);

    UserNewDTO updateUser(Long id, UserNewDTO user);

    void deleteUser(Long id);
}
