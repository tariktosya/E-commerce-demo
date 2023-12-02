package com.demo.app.dto.request;

public record OrderRequestDto(
        Double totalPrice,
        Long customerId
) {
}
