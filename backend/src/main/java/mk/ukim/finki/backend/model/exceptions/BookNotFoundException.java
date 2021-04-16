package mk.ukim.finki.backend.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with id %d does not exists",id));
    }
}
