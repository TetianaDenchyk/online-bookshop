package com.bookshop.dto.cartitem;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCartItemDto(@NotNull Long bookId,
                                @Positive @Size(min = 1, max = 1000) int quantity) {
}
