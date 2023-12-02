package com.demo.app.dto.response;

import java.time.Instant;

public record OrderResponseDto(
        Long id,
        Instant createDate,
        Double totalPrice
) {
}
