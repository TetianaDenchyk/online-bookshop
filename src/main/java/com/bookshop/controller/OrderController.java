package com.bookshop.controller;

import com.bookshop.dto.order.OrderRequestDto;
import com.bookshop.dto.order.OrderResponseDto;
import com.bookshop.model.User;
import com.bookshop.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "", description = "")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public OrderResponseDto placeOrder(Authentication authentication,
                                       @RequestBody OrderRequestDto requestDto) {
        User user = (User) authentication.getPrincipal();
        return orderService.createOrder(user, requestDto);
    }
}
