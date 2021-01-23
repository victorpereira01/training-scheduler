package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.domains.enums.UserType;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        users = users.stream().filter(user -> user.getType().equals(UserType.STUDENT)).collect(Collectors.toList());
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserNewDTO findById(Long id) {
        return new UserNewDTO(userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + User.class.getName())));
    }

    @Override
    public UserNewDTO insertUser(UserNewDTO userNewDto) {
        User user = new User(userNewDto.getId(), userNewDto.getName(), userNewDto.getEmail(),
                userNewDto.getPassword(), userNewDto.getBirthDate(), userNewDto.getType());
        return new UserNewDTO(userRepository.save(user));
    }

    @Override
    public UserNewDTO updateUser(Long id, UserNewDTO newUser) {
        findById(id);
        User user = new User(id, newUser.getName(), newUser.getEmail(), newUser.getPassword(),
                newUser.getBirthDate(), newUser.getType());
        return new UserNewDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(findById(id).getId());
    }
}
