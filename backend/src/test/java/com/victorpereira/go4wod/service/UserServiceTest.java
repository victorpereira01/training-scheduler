package com.victorpereira.go4wod.service;

import com.victorpereira.go4wod.builder.UserBuilder;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.UserServiceImpl;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void whenInsertUserThenShouldBeCreated() {
        User user = UserBuilder.builder().build().toUser();
        UserNewDTO userNewDTO = new UserNewDTO(user);

        when(userRepository.save(user)).thenReturn(user);

        UserNewDTO createdUser = userService.insertUser(userNewDTO);
        assertEquals(userNewDTO.getId(), createdUser.getId());
        assertEquals(userNewDTO.getName(), createdUser.getName());
        assertEquals(userNewDTO.getEmail(), createdUser.getEmail());
    }

    @Test
    void whenUpdateUserThenShouldBeUpdated() {
        User user = UserBuilder.builder().build().toUser();

        User user1 = UserBuilder.builder()
                .name("Victor Pereira")
                .email("victor.p@gmail.com")
                .build().toUser();
        UserNewDTO userNewDTO1 = new UserNewDTO(user1);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.save(user1)).thenReturn(user1);

        UserNewDTO updatedUser = userService.updateUser(user.getId(), userNewDTO1);
        assertEquals(userNewDTO1.getId(), updatedUser.getId());
        assertEquals(userNewDTO1.getName(), updatedUser.getName());
        assertEquals(userNewDTO1.getEmail(), updatedUser.getEmail());
    }

    @Test
    void whenUpdateUserThenAnExceptionShouldBeThrown() throws ObjectNotFoundException {
        User user = UserBuilder.builder().build().toUser();
        UserNewDTO userNewDTO = new UserNewDTO(user);

        assertThrows(ObjectNotFoundException.class, () -> userService.updateUser(userNewDTO.getId(), userNewDTO));
    }

    @Test
    void whenFindAllUsersThenShouldReturnUsersList() {
        User user1 = UserBuilder.builder().build().toUser();
        UserDTO userDTO1 = new UserDTO(user1);

        User user2 = UserBuilder.builder()
                .id(2L)
                .build().toUser();
        UserDTO userDTO2 = new UserDTO(user2);

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        assertThat(userService.findAll(), is(not(empty())));
        assertThat(userService.findAll(), contains(userDTO1, userDTO2));
    }

    @Test
    void whenFindAllUsersThenReturnEmptyList() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(userService.findAll(), is(empty()));
    }

    @Test
    void whenDeleteUserThenShouldBeDeleted() {
        User user = UserBuilder.builder().build().toUser();
        UserNewDTO userNewDTO = new UserNewDTO(user);

        when(userRepository.findById(userNewDTO.getId())).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById(userNewDTO.getId());

        userService.deleteUser(userNewDTO.getId());
        verify(userRepository, times(1)).findById(userNewDTO.getId());
        verify(userRepository, times(1)).deleteById(userNewDTO.getId());
    }

    @Test
    void whenDeleteUserThenAnExceptionShouldBeThrown() throws ObjectNotFoundException {
        User user = UserBuilder.builder().build().toUser();
        UserNewDTO userNewDTO = new UserNewDTO(user);

        assertThrows(ObjectNotFoundException.class, () -> userService.deleteUser(userNewDTO.getId()));
    }
}
