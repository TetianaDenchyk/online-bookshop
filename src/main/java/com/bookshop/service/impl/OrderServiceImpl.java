package com.bookshop.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import com.bookshop.dto.order.OrderRequestDto;
import com.bookshop.dto.order.OrderResponseDto;
import com.bookshop.exception.EntityNotFoundException;
import com.bookshop.mapper.OrderMapper;
import com.bookshop.model.CartItem;
import com.bookshop.model.Order;
import com.bookshop.model.OrderItem;
import com.bookshop.model.ShoppingCart;
import com.bookshop.model.User;
import com.bookshop.repository.OrderRepository;
import com.bookshop.repository.ShoppingCartRepository;
import com.bookshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    @Override
    public OrderResponseDto createOrder(User user, OrderRequestDto orderRequestDto) {
        // find shopping cart by user id
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByUserId(user.getId()).orElseThrow(
                () -> new EntityNotFoundException("There is no user with the id: " + user.getId())
        );
        // take all cart items in shopping cart
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Order.Status.CREATED);
        order.setShippingAddress(orderRequestDto.shippingAddress());
        Set<CartItem> cartItems = shoppingCart.getCartItems();
        Set<OrderItem> orderItems = new HashSet<>();
        order.setOrderItems(orderItems);
        // turn them into order items
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getBook().getPrice());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
//            shoppingCart.removeCartItem(cartItem);
//            cartItem.setShoppingCart(null);
        }
//        cartItems.stream().forEach(shoppingCart::removeCartItem);

        // count price of each book

        BigDecimal total = order.getOrderItems().stream()
                .map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        order.setTotal(total);
        // count total price
        // set status as created
//        shoppingCart.setCartItems(null);
        return orderMapper.toDto(orderRepository.save(order));
    }
}
