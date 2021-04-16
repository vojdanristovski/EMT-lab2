package mk.ukim.finki.backend.service;

import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.dto.BookDto;
import mk.ukim.finki.backend.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long author, Integer availableCopies);

    Optional<Book> edit(Long id,String name,Category category,Long author,Integer availableCopies);

    void deleteById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id,BookDto bookDto);

    List<Category> categories();
}
