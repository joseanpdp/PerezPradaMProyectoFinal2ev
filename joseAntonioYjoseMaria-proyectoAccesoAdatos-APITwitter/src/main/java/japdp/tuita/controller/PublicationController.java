package japdp.tuita.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import japdp.tuita.dto.PublicationGetDto;
import japdp.tuita.dto.PublicationPostDto;
import japdp.tuita.dto.PublicationPutDto;
import japdp.tuita.service.PublicationService;

@RequestMapping("/api/publication")
@RestController
@CrossOrigin
public class PublicationController {

	@Autowired
	private PublicationService publicationService;

	
	/** CRUD **/ 
	
	@GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
	public PublicationGetDto findById(@PathVariable long id) {
		return publicationService.findById(id);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
	public void deleteById(@PathVariable long id) {
		publicationService.deleteById(id);
	}
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void insert(@RequestBody PublicationPostDto publicationPostDto) {
        publicationService.insert(publicationPostDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable long id, @RequestBody PublicationPutDto publicationPutDto) {
        publicationService.update(id, publicationPutDto);
    }
    
	/** Get all **/ 
	
	@GetMapping
    @ResponseStatus(code = HttpStatus.OK)
	public List<PublicationGetDto> getAll() {
		return publicationService.findAll();
	}
	
}

