package com.example.openschoolthirdhomework.service;

import com.example.openschoolthirdhomework.dto.OrderDto;
import com.example.openschoolthirdhomework.exception.IdAlreadyExistException;
import com.example.openschoolthirdhomework.exception.ResourceNotFoundException;
import com.example.openschoolthirdhomework.mapper.OrderMapper;
import com.example.openschoolthirdhomework.model.Order;
import com.example.openschoolthirdhomework.model.User;
import com.example.openschoolthirdhomework.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    private final OrderMapper mapper;

    private final UserService userService;


    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {

        List<Order> orders = repository.findAll();

        return mapper.toDtoList(orders);
    }

    @Transactional
    public OrderDto create(OrderDto orderDto) {
        if (orderDto.getId() != null) {
            throw new IdAlreadyExistException("You cannot create an entity with existing id");
        }

        User user = userService.findUserIfExists(orderDto.getUserId());
        Order order = mapper.toEntity(orderDto, user);

        Order orderAfterSaved = repository.save(order);
        return mapper.toDto(orderAfterSaved);
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        Order order = findOrderIfExists(id);

        return mapper.toDto(order);
    }

    @Transactional
    public OrderDto update(OrderDto orderDto, Long id) {
        Order oldOrder = findOrderIfExists(id);
        User user = userService.findUserIfExists(orderDto.getUserId());
        Order order = mapper.toEntity(orderDto, user);
        order.setId(oldOrder.getId());
        Order orderAfterSaved = repository.save(order);
        return mapper.toDto(orderAfterSaved);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    public Order findOrderIfExists(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
    }


}
