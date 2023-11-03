package com.bookshop.mapper;

import com.bookshop.config.MapperConfig;
import com.bookshop.dto.category.CategoryDto;
import com.bookshop.model.Category;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    Category toCategory(CategoryDto categoryDto);

    CategoryDto toDto(Category category);
}
