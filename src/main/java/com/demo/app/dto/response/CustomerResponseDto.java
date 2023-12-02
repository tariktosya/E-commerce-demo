package com.demo.app.dto.response;

import java.util.Set;

public record CustomerResponseDto(
        Long id,
        String name,
        Integer age,
        Set<OrderResponseDto> orderList
) {
}
