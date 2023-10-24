package com.bookshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record CreateBookRequestDto(@NotBlank String title,
                                   @NotBlank String author,
                                   @NotBlank @Pattern(
                                           regexp = """
                                                   ^(?=(?:[^0-9]*[0-9]){10}
                                                   (?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$
                                                   """)
                                   String isbn,
                                   @NotNull @PositiveOrZero BigDecimal price,
                                   String description,
                                   String coverImage) {

}
