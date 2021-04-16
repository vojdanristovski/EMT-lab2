package mk.ukim.finki.backend.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id %d does not exists",id));
    }
}
