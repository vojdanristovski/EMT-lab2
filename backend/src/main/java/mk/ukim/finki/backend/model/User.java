package mk.ukim.finki.backend.model;

import lombok.Data;
import mk.ukim.finki.backend.model.enumerations.Role;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book_users")
public class User {

    @Id
    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;


}
