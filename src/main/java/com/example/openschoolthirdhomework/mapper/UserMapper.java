package com.example.openschoolthirdhomework.mapper;

import com.example.openschoolthirdhomework.dto.UserDto;
import com.example.openschoolthirdhomework.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class UserMapper {

    private final OrderMapper orderMapper;

    public UserDto toDto(User entity) {
        return UserDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .orders(orderMapper.toDtoList(new ArrayList<>(Objects.requireNonNullElse(entity.getOrders(), Collections.EMPTY_SET))))
                .build();
    }

    public User toEntity(UserDto dto) {
        return User
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public List<UserDto> toDtoList(List<User> entities) {
        return entities.stream().map(this::toDto).toList();
    }

}
