package com.bookshop.controller;

import jakarta.validation.constraints.Positive;
import com.bookshop.dto.order.OrderRequestDto;
import com.bookshop.dto.order.OrderResponseDto;
import com.bookshop.dto.order.OrderStatusUpdateDto;
import com.bookshop.dto.orderitem.OrderItemResponseDto;
import com.bookshop.model.User;
import com.bookshop.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Operation
    @PreAuthorize("hasRole('USER')")
    public OrderResponseDto createOrder(Authentication authentication,
                                        @RequestBody OrderRequestDto requestDto) {
        User user = (User) authentication.getPrincipal();
        return orderService.createOrder(user, requestDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<OrderResponseDto> getAllOrders(Authentication authentication,
                                               Pageable pageable) {
        User user = (User) authentication.getPrincipal();
        return orderService.findAllOrders(user.getId(), pageable);
    }

    @GetMapping("/{orderId}/items")
    @PreAuthorize("hasRole('USER')")
    public List<OrderItemResponseDto> getOrderItemsOfOrder(@PathVariable @Positive Long orderId,
                                                           Pageable pageable,
                                                           Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return orderService.findAllByOrderId(orderId, pageable, user.getId());
    }

    @GetMapping("{orderId}/items/{id}")
    @PreAuthorize("hasRole('USER')")
    public OrderItemResponseDto getOrderItemWithinOrder(@PathVariable @Positive Long orderId,
                                                        @PathVariable @Positive Long id,
                                                        Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return orderService.findOrderItemByIdInOrder(orderId, id, user.getId());
    }

    @PatchMapping("/{orderId}")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderResponseDto updateStatus(@PathVariable @Positive Long orderId,
                                         @RequestBody OrderStatusUpdateDto updateDto) {
        return orderService.updateOrderStatus(orderId, updateDto.newStatus());
    }
}
