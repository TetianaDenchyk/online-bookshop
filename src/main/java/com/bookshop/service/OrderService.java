package com.bookshop.service;

import com.bookshop.dto.order.OrderRequestDto;
import com.bookshop.dto.order.OrderResponseDto;
import com.bookshop.model.User;

public interface OrderService {
    OrderResponseDto createOrder(User User,
                                 OrderRequestDto orderRequestDto);
}
