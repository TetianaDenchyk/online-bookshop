package com.bookshop.repository;

import com.bookshop.model.Book;
import com.bookshop.model.Category;
import java.util.List;
import org.mapstruct.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    List<Book> findAllByCategoryId(Long categoryId);
}
