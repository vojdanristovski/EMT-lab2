package mk.ukim.finki.backend.service.impl;

import mk.ukim.finki.backend.model.Author;
import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.dto.BookDto;
import mk.ukim.finki.backend.model.enumerations.Category;
import mk.ukim.finki.backend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.backend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.backend.repository.AuthorRepository;
import mk.ukim.finki.backend.repository.BookRepository;
import mk.ukim.finki.backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository repository, AuthorRepository authorRepository) {
        this.bookRepository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long author, Integer availableCopies) {
        Author a = this.authorRepository.findById(author)
                .orElseThrow(()->new AuthorNotFoundException(author));

        return Optional.of(this.bookRepository.save(new Book(name,category,a,availableCopies)));
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long author, Integer availableCopies) {
        Book b = this.bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException(id));
        Author a = this.authorRepository.findById(author)
                .orElseThrow(()->new AuthorNotFoundException(author));

        b.setName(name);
        b.setAuthor(a);
        b.setAvailableCopies(availableCopies);
        b.setCategory(category);

        return Optional.of(b);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
       Category c = bookDto.getCategory();
       Author a = authorRepository.findById(bookDto.getAuthor())
               .orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));

       return Optional.of(bookRepository.save(new Book(bookDto.getName(),c,a,bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException(id));

        book.setCategory(bookDto.getCategory());
        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author a = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(()->new AuthorNotFoundException(bookDto.getAuthor()));

        book.setAuthor(a);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public List<Category> categories() {
        return Arrays.asList(Category.values().clone());
    }
}
