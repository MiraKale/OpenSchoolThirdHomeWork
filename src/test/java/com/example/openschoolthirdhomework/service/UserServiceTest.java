package com.example.openschoolthirdhomework.service;

import com.example.openschoolthirdhomework.dto.UserDto;
import com.example.openschoolthirdhomework.mapper.UserMapper;
import com.example.openschoolthirdhomework.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class UserServiceTest {
    private final static long ID = 1L;

    UserDto userDto = mock(UserDto.class);
    @Mock
    private UserRepository repository;
    @Mock
    private UserMapper mapper;
    @InjectMocks
    private UserService userService;

    @Test
    void findAll() {
        userService.findAll();
    }

    @Test
    void create() {
        userService.create(userDto);
    }

    @Test
    void findById() {
        userService.findById(ID);
    }

    @Test
    void update() {
        userService.update(userDto, ID);
    }

    @Test
    void deleteById() {
        userService.deleteById(ID);
    }
}
