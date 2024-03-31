package com.example.openschoolthirdhomework.service;

import com.example.openschoolthirdhomework.dto.UserDto;
import com.example.openschoolthirdhomework.exception.IdAlreadyExistException;
import com.example.openschoolthirdhomework.exception.ResourceNotFoundException;
import com.example.openschoolthirdhomework.mapper.UserMapper;
import com.example.openschoolthirdhomework.model.User;
import com.example.openschoolthirdhomework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Transactional
    public List<UserDto> findAll() {
        List<User> users = repository.findAll();
        return mapper.toDtoList(users);
    }

    @Transactional
    public UserDto create(UserDto userDto) {
        if (userDto.getId() != null) {
            throw new IdAlreadyExistException("You cannot create an entity with existing id");
        }

        User user = mapper.toEntity(userDto);
        User userAfterSaved = repository.save(user);
        return mapper.toDto(userAfterSaved);
    }

    @Transactional
    public UserDto findById(Long id) {
        User user = findUserIfExists(id);
        return mapper.toDto(user);
    }

    @Transactional
    public UserDto update(UserDto userDto, Long id) {
        User oldUser = findUserIfExists(id);
        User user = mapper.toEntity(userDto);
        user.setId(oldUser.getId());
        User userAfterSaved = repository.save(user);
        return mapper.toDto(userAfterSaved);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public User findUserIfExists(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
    }

}
