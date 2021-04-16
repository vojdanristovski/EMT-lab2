package mk.ukim.finki.backend.web;

import mk.ukim.finki.backend.model.Book;
import mk.ukim.finki.backend.model.dto.BookDto;
import mk.ukim.finki.backend.service.BookService;
import mk.ukim.finki.backend.service.impl.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/","/books"})
@CrossOrigin(origins = "http://localhost:3000")
public class BookConroller {
    private final BookService bookService;

    public BookConroller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll()
    {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id)
    {
        return this.bookService.findById(id)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto)
    {
        return this.bookService.save(bookDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id,@RequestBody BookDto bookDto)
    {
        return this.bookService.edit(id,bookDto)
                .map(book->ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id)
    {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
