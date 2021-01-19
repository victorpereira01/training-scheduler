package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.enums.UserType;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + User.class.getName()));
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User newUser = findById(id);
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setBirthDate(user.getBirthDate());
        newUser.setType(UserType.toEnum(user.getType().getCode()));
        return userRepository.save(newUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(findById(id).getId());
    }
}
