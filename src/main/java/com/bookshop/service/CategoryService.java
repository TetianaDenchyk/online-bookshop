package com.bookshop.service;

import java.util.List;
import com.bookshop.dto.book.BookDto;
import com.bookshop.dto.category.CategoryDto;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    List<CategoryDto> findAll(Pageable pageable);
}
