package com.bookshop.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.bookshop.model.Order;

public record OrderResponseDto(Long userId,
                               Order.Status status,
                               BigDecimal total,
                               LocalDateTime orderDate,
                               String shippingAddress) {
}
