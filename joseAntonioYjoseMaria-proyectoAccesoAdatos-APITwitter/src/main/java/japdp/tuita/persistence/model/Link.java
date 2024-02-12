package japdp.tuita.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "links")
public class Link {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @ManyToOne
    @JoinColumn(name = "followed")
	private User followed;
    
    /* En principio era OneToOne pero
     * en este caso Hibernate añadía automaticamente
     * una restricción unique
     * alter table links add constraint UK_5pk8vt2iqrhpgnfnlhoa3kujo unique (follower);
     * 
     * Un problema similar se comenta aqui:
     * https://stackoverflow.com/questions/69310731/hibernate-adds-unwanted-unique-key-itself-in-onetomany-mapping
     */
    @ManyToOne
    @JoinColumn(name = "follower")
    private User follower;
	
    public Link(User followed, User follower) {
    	this.followed = followed;
    	this.follower = follower;
    }

}
