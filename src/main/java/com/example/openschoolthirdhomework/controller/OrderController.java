package com.example.openschoolthirdhomework.controller;

import com.example.openschoolthirdhomework.dto.OrderDto;
import com.example.openschoolthirdhomework.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAll() {
        return orderService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto show(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@RequestBody OrderDto orderDto, @PathVariable Long id) {
        return orderService.update(orderDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
