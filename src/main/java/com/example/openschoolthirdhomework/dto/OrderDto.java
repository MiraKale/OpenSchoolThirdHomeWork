package com.example.openschoolthirdhomework.dto;

import com.example.openschoolthirdhomework.enums.OrderStatus;
import lombok.*;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderDto {
    private Long id;
    private String description;
    private OrderStatus status;
    private Long userId;
}
