package japdp.tuita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.tuita.dto.PublicationGetDto;
import japdp.tuita.dto.UserGetDto;
import japdp.tuita.dto.UserPostDto;
import japdp.tuita.dto.UserPutDto;
import japdp.tuita.exceptions.UserNotFoundException;
import japdp.tuita.persistence.model.User;
import japdp.tuita.persistence.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserGetDto findById(long id) {
		Optional<UserGetDto> optionalUserGetDto = userRepository.findUserGetDtoById(id);
		if (optionalUserGetDto.isPresent()) {
			return optionalUserGetDto.get();
		} else {
			throw new UserNotFoundException(id);
		}
	}

	public UserGetDto findByUsername(String username) {
		Optional<UserGetDto> optionalUserGetDto = userRepository.findUserGetDtoByUsername(username);
		if (optionalUserGetDto.isPresent()) {
			return optionalUserGetDto.get();
		} else {
			throw new UserNotFoundException(username);
		}
	}	
	
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public void insert(UserPostDto userPostDTO) {
		User user = new User( userPostDTO.getUserName()
				            , userPostDTO.getEmail()
				            , userPostDTO.getPassword()
				            , userPostDTO.getDescription()
				            , userPostDTO.getCreationDate());				
		userRepository.save(user);
	}

	public void update(UserPutDto userPutDto) {
		Long id = userPutDto.getId();
		Optional<User> optionalUser = userRepository.findById(id);
		if ( optionalUser.isPresent() ) {
			User user = optionalUser.get();
			// En esta versión los atributos únicos no podrán ser actualizados
			// user.setUsername(userDTO.getUsername());
			// user.setEmail(userDTO.getEmail());
	        user.setPassword(userPutDto.getPassword());
	        user.setDescription(userPutDto.getDescription());
	        user.setCreationDate(userPutDto.getCreationDate());				
            userRepository.save(user);
		}
		else {
			throw new UserNotFoundException(id);
		}
	}

	public void setDescriptionById(Long id, String description) {
		Optional<User> optionalUser = userRepository.findById(id);
		if ( optionalUser.isPresent() ) {
			User user = optionalUser.get();
	        user.setDescription(description);
            userRepository.save(user);
		}
		else {
			throw new UserNotFoundException(id);
		}
	}

	
	public List<UserGetDto> findAll() {
		return userRepository.findAllUserGetDto();
	}

	public List<UserGetDto> findFollowerPeopleById(Long id) {
		return userRepository.findFollowerPeopleGetDtoById(id);
	}

	public List<UserGetDto> findFollowedPeopleById(Long id) {
		return userRepository.findFollowedPeopleGetDtoById(id);
	}

	public List<PublicationGetDto> findPublicationsById(Long id) {
		return userRepository.findPublicationsGetDtoById(id);
	}

	public List<PublicationGetDto> findFollowedPeoplePublicationsById(Long id) {
		return userRepository.findFollowedPeoplePublicationsGetDtoById(id);
	}
	
/*
	public List<PublicationGetDto> findPublicationsById(Long id) {
		List<Publication> publications = userRepository.findPublicationsByUserId(id);
		List<PublicationGetDto> publicationDTOs = new ArrayList<>();
		for (Publication publication : publications) {
			publicationDTOs.add(new PublicationGetResponseDto(publication));
		}
		return publicationDTOs;
	}

	public List<PublicationGetto> findFollowedPeoplePublicationsById(Long id) {
		List<Publication> publications = userRepository.findFollowedPeoplePublicationsById(id);
		List<PublicationGetDto> publicationDTOs = new ArrayList<>();
		for (Publication publication : publications) {
			publicationDTOs.add(new PublicationGetResponseDto(publication));
		}
		return publicationDTOs;
	}

*/


}
