package com.bookshop.dto.cartitem;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCartItemDto(@NotNull Long bookId,
                                @Positive Integer quantity) {
}
