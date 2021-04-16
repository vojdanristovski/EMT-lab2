package mk.ukim.finki.backend.web;

import mk.ukim.finki.backend.model.Author;
import mk.ukim.finki.backend.repository.AuthorRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> getAll()
    {
        return this.authorRepository.findAll();
    }
}
