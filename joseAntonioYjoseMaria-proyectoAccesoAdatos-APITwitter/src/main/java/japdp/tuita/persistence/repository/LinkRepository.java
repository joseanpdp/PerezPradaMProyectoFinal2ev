package japdp.tuita.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import japdp.tuita.persistence.model.Link;

public interface LinkRepository  extends JpaRepository<Link, Long> {
	
	@Query("SELECT k FROM Link k JOIN k.followed d JOIN k.follower r WHERE d.id =:followedId AND r.id =:followerId")
	Optional<Link> findByFollowedIdFollowerId(Long followedId, Long followerId);

}
