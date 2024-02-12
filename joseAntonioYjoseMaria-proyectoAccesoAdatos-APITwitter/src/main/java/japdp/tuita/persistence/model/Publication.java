package japdp.tuita.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "publications")
public class Publication {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    
	@Column(name = "text")
    private String text;

    @Column(name = "creationDate")
    private String creationDate;

    @Column(name = "editionDate")
    private String editionDate;

	public Publication(User user, String text, String creationDate, String editionDate) {
		this.user         = user;
		this.text         = text;
		this.creationDate = creationDate;
		this.editionDate  = editionDate;
	}
    
}
