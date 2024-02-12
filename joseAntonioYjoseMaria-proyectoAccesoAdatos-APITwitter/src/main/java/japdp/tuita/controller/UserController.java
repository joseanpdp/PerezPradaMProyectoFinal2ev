package japdp.tuita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import japdp.tuita.dto.PublicationGetDto;
import japdp.tuita.dto.UserGetDto;
import japdp.tuita.dto.UserPostDto;
import japdp.tuita.dto.UserPutDto;
import japdp.tuita.service.UserService;

@RequestMapping("/api/user")
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
	public List<UserGetDto> findAll() {
		return userService.findAll();
	}

	/** CRUD **/ 
    
	@GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
	public UserGetDto findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insert(@RequestBody UserPostDto userPostDto) {
        userService.insert(userPostDto);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody UserPutDto userPutDto) {
        userService.update(userPutDto);
    }
    
    /** Get by user name**/
    
	@GetMapping("/username/{username}")
    @ResponseStatus(code = HttpStatus.OK)
	public UserGetDto findByUserName(@PathVariable String username) {
		return userService.findByUsername(username);
	}
	
	/** Get people who follow the user [PROTECTED]**/

	@GetMapping("/{id}/followerpeople")
    @ResponseStatus(code = HttpStatus.OK)
	public List<UserGetDto> findFollowerPeopleById(@PathVariable Long id) {
		return userService.findFollowerPeopleById(id);
	}

	/** Get people the user follows [PROTECTED]**/

	@GetMapping("/{id}/followedpeople")
    @ResponseStatus(code = HttpStatus.OK)
	public List<UserGetDto> findFollowedPeopleById(@PathVariable Long id) {
		return userService.findFollowedPeopleById(id);
	}

	/** Modify description (privado) [PROTECTED]**/
	
	@PatchMapping("/{id}/description/{description}")
    @ResponseStatus(code = HttpStatus.OK)
	public void setDescriptionById(@PathVariable Long id, @PathVariable String description) {
		userService.setDescriptionById(id, description);
	}


	@GetMapping("/{id}/publications")
    @ResponseStatus(code = HttpStatus.OK)
	public List<PublicationGetDto> findPublicationsById(@PathVariable Long id) {
		return userService.findPublicationsById(id);
	}


	@GetMapping("/{id}/followedpeople/publications")
    @ResponseStatus(code = HttpStatus.OK)
	public List<PublicationGetDto> findFollowedPeoplePublicationsById(@PathVariable Long id) {
		return userService.findFollowedPeoplePublicationsById(id);
	}


	
}


