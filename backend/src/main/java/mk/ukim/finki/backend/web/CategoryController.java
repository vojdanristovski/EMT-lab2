package mk.ukim.finki.backend.web;

import mk.ukim.finki.backend.model.enumerations.Category;
import mk.ukim.finki.backend.service.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private final BookService bookService;

    public CategoryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Category> findAll()
    {
        return this.bookService.categories();
    }
}
