package mk.ukim.finki.backend.repository;

import mk.ukim.finki.backend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
