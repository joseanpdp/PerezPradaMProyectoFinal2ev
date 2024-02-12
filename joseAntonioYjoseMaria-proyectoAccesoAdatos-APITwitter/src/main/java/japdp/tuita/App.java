package japdp.tuita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import japdp.tuita.dto.UserGetDto;
import japdp.tuita.persistence.model.Publication;
import japdp.tuita.persistence.model.User;
import japdp.tuita.persistence.repository.LinkRepository;
import japdp.tuita.persistence.repository.PublicationRepository;
import japdp.tuita.persistence.repository.UserRepository;
import japdp.tuita.service.LinkService;

@SpringBootApplication
public class App implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LinkRepository linkRepository;
	
	@Autowired
	private LinkService linkService;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Override
	public void run(String... args) {
		
		Publication publication;

		User user1 = new User("Jose1", "jose1@example.es", "321", "Jose1 descrito", "2024-02-02");
		userRepository.save(user1);
		publication = new Publication(user1, "Primera publicación de Jose1", "2024-02-03", "2024-02-03");
		user1.addPublication(publication);
		publicationRepository.save(publication);

		User user2 = new User("Jose2", "jose2@example.es", "123", "Jose2 descrito", "2024-02-01");
		userRepository.save(user2);
		publication = new Publication(user2, "Primera publicación de Jose2", "2024-02-02", "2024-02-05");
		user2.addPublication(publication);	
		publicationRepository.save(publication);
		publication = new Publication(user2, "Segunda publicación de Jose2", "2024-03-02", "2024-03-05");
		user2.addPublication(publication);
		publicationRepository.save(publication);

		User user3 = new User("Jose3", "jose3@example.es", "101", "Jose3 descrito", "2024-02-10");
		userRepository.save(user3);
		publication = new Publication(user3, "Primera publicación de Jose3", "2024-02-11", "2024-02-15");
		user2.addPublication(publication);
		publicationRepository.save(publication);
		publication = new Publication(user3, "Segunda publicación de Jose3", "2024-02-12", "2024-02-14");
		user2.addPublication(publication);
		publicationRepository.save(publication);
		publication = new Publication(user3, "Tercera publicación de Jose3", "2024-02-20", "2024-02-21");
		user2.addPublication(publication);
		publicationRepository.save(publication);

		linkService.add(user3, user1);
		linkService.add(user3, user2);
		linkService.add(user2, user3);
		linkService.add(user1, user3);
		linkService.add(user2, user1);
				


/*
		System.out.println("====================================");

		List<User> users = userRepository.findFollowerPeopleById(1L);
		for (User u : users) System.out.println(u.getId() + ":" + u.getUsername());

		System.out.println("====================================");
		
		users = userRepository.findFollowerPeopleById(2L);
		for (User u : users) System.out.println(u.getId() + ":" + u.getUsername());

		System.out.println("====================================");
		
		users = userRepository.findFollowerPeopleById(3L);
		for (User u : users) System.out.println(u.getId() + ":" + u.getUsername());

		System.out.println("====================================");
		System.out.println("====================================");
		System.out.println("====================================");

		users = userRepository.findFollowedPeopleById(1L);
		for (User u : users) System.out.println(u.getId() + ":" + u.getUsername());

		System.out.println("====================================");
		
		users = userRepository.findFollowedPeopleById(2L);
		for (User u : users) System.out.println(u.getId() + ":" + u.getUsername());

		System.out.println("====================================");
		
		users = userRepository.findFollowedPeopleById(3L);
		for (User u : users) System.out.println(u.getId() + ":" + u.getUsername());

		System.out.println("====================================");
		System.out.println("====================================");
		System.out.println("====================================");
		
		List<UserGetDto> userGetDtos = userRepository.findAllUserGetDto();
		for (UserGetDto u : userGetDtos) System.out.println(u.getId() + ":" + u.getUsername());

		UserGetDto userGetDto = userRepository.findUserGetDtoById(1L).get();
		System.out.println(alfa(userGetDto));
		
		System.out.println("====================================");
		System.out.println("============Followers========================");
		System.out.println("====================================");
		
		userGetDtos = userRepository.findFollowerPeopleGetDtoById(3L);
		for (UserGetDto u : userGetDtos) System.out.println(alfa(u));
		
		System.out.println("====================================");
		System.out.println("==============Followeds======================");
		System.out.println("====================================");
		
		userGetDtos = userRepository.findFollowedPeopleGetDtoById(3L);
		for (UserGetDto u : userGetDtos) System.out.println(alfa(u));
		
		System.out.println("====================================");
		System.out.println("==============Followeds pubs======================");
		System.out.println("====================================");
		
		List<Publication> ps = userRepository.findFollowedPeoplePublicationsById(1L);
		for (Publication p : ps) System.out.println(beta(p));

		System.out.println("====================================");

		ps = userRepository.findFollowedPeoplePublicationsById(2L);
		for (Publication p : ps) System.out.println(beta(p));

		System.out.println("====================================");

		ps = userRepository.findFollowedPeoplePublicationsById(3L);
		for (Publication p : ps) System.out.println(beta(p));

		System.out.println("====================================");
*/
		
	}
	
	String alfa(UserGetDto u) {
		return u.getId() + "," + u.getUsername() + "," + u.getEmail() + "," + u.getDescription() +"," + u.getCreationDate();
	}

	String beta(Publication p) {
		return p.getId() + "," + p.getText() + "," + p.getUser().getUsername() + "," + p.getCreationDate();
	}

}
