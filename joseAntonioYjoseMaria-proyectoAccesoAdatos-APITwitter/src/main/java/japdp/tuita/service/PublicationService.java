package japdp.tuita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.tuita.dto.PublicationGetDto;
import japdp.tuita.dto.PublicationPostDto;
import japdp.tuita.dto.PublicationPutDto;
import japdp.tuita.exceptions.PublicationIncorrectAuthorException;
import japdp.tuita.exceptions.PublicationNotFoundException;
import japdp.tuita.persistence.model.Publication;
import japdp.tuita.persistence.model.User;
import japdp.tuita.persistence.repository.PublicationRepository;
import japdp.tuita.persistence.repository.UserRepository;

@Service
public class PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<PublicationGetDto> findAll() {
		return publicationRepository.findAllPublicationsGetDto();
	}

	public PublicationGetDto findById(Long id) {
		Optional<PublicationGetDto> optionalPublicationGetDto = publicationRepository.findPublicationGetDtoById(id);
		if (optionalPublicationGetDto.isPresent()) {
			return optionalPublicationGetDto.get();
		} else {
			throw new PublicationNotFoundException(id);
		}
	}
	
	public void deleteById(Long id) {
		publicationRepository.deleteById(id);
	}

	public void insert(PublicationPostDto publicationPostDto) {
        Long id = publicationPostDto.getUserId();
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			Publication publication = 
					new Publication( user
								   , publicationPostDto.getText()
								   , publicationPostDto.getCreationDate()			
								   , publicationPostDto.getEditionDate());				
			publicationRepository.save(publication);
		} else {
			throw new PublicationNotFoundException(id);
		}
	}

	public void update(PublicationPutDto publicationPutDto) {
		Long id = publicationPutDto.getId();
		Optional<Publication> optionalPublication = publicationRepository.findById(id);
		if ( optionalPublication.isPresent() ) {
			Publication publication = optionalPublication.get();
			if ( publication.getUser().getId().equals(publicationPutDto.getUserId())) {
				publication.setText(publicationPutDto.getText());
				publication.setCreationDate(publicationPutDto.getCreationDate());				
				publication.setEditionDate(publicationPutDto.getEditionDate());				
				publicationRepository.save(publication);
			}
			else {
				throw new PublicationIncorrectAuthorException(id);
			}
		}
		else {
			throw new PublicationNotFoundException(id);
		}
	}





}
