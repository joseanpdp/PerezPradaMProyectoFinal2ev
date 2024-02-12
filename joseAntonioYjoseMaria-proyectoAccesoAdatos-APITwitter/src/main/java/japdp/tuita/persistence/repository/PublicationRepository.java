package japdp.tuita.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import japdp.tuita.dto.PublicationGetDto;
import japdp.tuita.dto.UserGetDto;
import japdp.tuita.persistence.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	
	@Query("SELECT p.id as id, p.user.id as userId, p.text as text,"
			+ " p.creationDate as creationDate, p.editionDate as editionDate,"
			+ " p.user.username as userUsername"
			+ " FROM Publication p JOIN p.user")
	List<PublicationGetDto> findAllPublicationsGetDto();
	
	@Query("SELECT p.id as id, p.user.id as userId, p.text as text,"
			+ " p.creationDate as creationDate, p.editionDate as editionDate,"
			+ " p.user.username as userUsername"
			+ " FROM Publication p JOIN p.user "
			+ " WHERE p.id =:id")
	Optional<PublicationGetDto> findPublicationGetDtoById(Long id);
}

