package com.bookshop.mapper;

import com.bookshop.config.MapperConfig;
import com.bookshop.dto.book.BookDto;
import com.bookshop.dto.book.CreateBookRequestDto;
import com.bookshop.model.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toBook(CreateBookRequestDto requestDto);

    void updateBook(CreateBookRequestDto dto, @MappingTarget Book book);

//    BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);
//
//    @AfterMapping
//    default void setCategoriesIds(@MappingTarget BookDto bookDto, Book book) {
//
//    }
}
