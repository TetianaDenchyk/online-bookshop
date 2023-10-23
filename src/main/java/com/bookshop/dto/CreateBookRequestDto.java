package com.bookshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.ISBN;

public record CreateBookRequestDto(@NotBlank String title,
                                   @NotBlank String author,
                                   @NotBlank @ISBN(type = ISBN.Type.ANY) String isbn,
                                   @NotNull @PositiveOrZero BigDecimal price,
                                   String description,
                                   String coverImage) {

}
