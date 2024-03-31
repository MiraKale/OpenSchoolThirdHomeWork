package com.example.openschoolthirdhomework.controller;

import com.example.openschoolthirdhomework.dto.UserDto;
import com.example.openschoolthirdhomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getAll() {
        return service.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userDto) {
        return service.create(userDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto show(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto update(@RequestBody UserDto userDto, @PathVariable Long id) {
        return service.update(userDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

}
