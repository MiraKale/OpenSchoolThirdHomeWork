package com.example.openschoolthirdhomework.service;

import com.example.openschoolthirdhomework.dto.OrderDto;
import com.example.openschoolthirdhomework.mapper.OrderMapper;
import com.example.openschoolthirdhomework.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class OrderServiceTest {

    private final static long ID = 1L;

    OrderDto orderDto = mock(OrderDto.class);
    @Mock
    private OrderRepository repository;
    @Mock
    private OrderMapper mapper;
    @Mock
    private UserService userService;
    @InjectMocks
    private OrderService orderService;


    @Test
    void findAll() {
        orderService.findAll();
    }

    @Test
    void create() {
        orderService.create(orderDto);
    }

    @Test
    void findById() {
        orderService.findById(ID);
    }

    @Test
    void update() {
        orderService.update(orderDto, ID);
    }

    @Test
    void deleteById() {
        orderService.deleteById(ID);
    }

}
