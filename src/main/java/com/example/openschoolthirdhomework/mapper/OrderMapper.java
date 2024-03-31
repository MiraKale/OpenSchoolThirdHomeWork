package com.example.openschoolthirdhomework.mapper;

import com.example.openschoolthirdhomework.dto.OrderDto;
import com.example.openschoolthirdhomework.model.Order;
import com.example.openschoolthirdhomework.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderDto toDto(Order entity) {
        return OrderDto
                .builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .userId(entity.getUser().getId())
                .build();
    }

    public Order toEntity(OrderDto dto, User user) {
        return Order
                .builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .user(user)
                .build();
    }

    public List<OrderDto> toDtoList(List<Order> entities) {
        return entities.stream().map(this::toDto).toList();
    }

}
