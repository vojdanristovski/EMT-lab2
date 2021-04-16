package mk.ukim.finki.backend.repository;

import mk.ukim.finki.backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
    
}
