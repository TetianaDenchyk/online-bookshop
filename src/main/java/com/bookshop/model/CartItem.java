package com.bookshop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter
@SQLDelete(sql = "UPDATE cart_items SET is_deleted = true WHERE id=?")
@Where(clause = "is_deleted=false")
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "id")
    @Column(nullable = false)
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @Column(nullable = false)
    private Book book;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean isDeleted = false;
}
