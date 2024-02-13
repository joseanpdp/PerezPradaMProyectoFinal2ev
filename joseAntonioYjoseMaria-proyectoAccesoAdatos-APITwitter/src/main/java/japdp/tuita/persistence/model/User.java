package japdp.tuita.persistence.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "creationDate")
    private String creationDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Publication> publications;

    @OneToMany(mappedBy = "followed")
    private List<Link> links;

    public User(String username, String email, String password, String description, String creationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.description = description;
        this.creationDate = creationDate;
        this.publications = new ArrayList<>();
        this.links = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

}
