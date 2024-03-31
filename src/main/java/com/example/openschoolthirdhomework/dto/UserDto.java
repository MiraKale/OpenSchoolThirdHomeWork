package com.example.openschoolthirdhomework.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private List<OrderDto> orders = new ArrayList<>();
}
