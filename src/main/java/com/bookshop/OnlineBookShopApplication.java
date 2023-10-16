package com.bookshop;

import com.bookshop.model.Book;
import com.bookshop.service.BookService;
import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineBookShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return args -> {
            Book book1 = new Book();
            book1.setAuthor("Ernest Hemingway");
            book1.setTitle("The Fiesta: Sun Also Rises");
            book1.setIsbn("9780099908500");
            book1.setPrice(BigDecimal.valueOf(200));
            bookService.save(book1);
            System.out.println(bookService.findAll());
        };
    }
}
