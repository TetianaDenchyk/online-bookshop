package com.bookshop.repository;

import com.bookshop.model.ShoppingCart;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @EntityGraph(attributePaths = {"user", "cartItems"})
    Optional<ShoppingCart> findShoppingCartByUserId(Long userId);
}
