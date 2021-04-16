package mk.ukim.finki.backend.model.dto;

import lombok.Data;
import mk.ukim.finki.backend.model.enumerations.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class BookDto {

    private String name;

    private Integer availableCopies;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Long author;

    public BookDto(String name, Integer availableCopies, Category category, Long author) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }

    public BookDto() {
    }
}
