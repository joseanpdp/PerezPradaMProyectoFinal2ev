package japdp.tuita.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.tuita.persistence.model.Link;
import japdp.tuita.persistence.model.User;
import japdp.tuita.persistence.repository.LinkRepository;

@Service
public class LinkService {

	@Autowired
	private LinkRepository linkRepository;
	
	public void add(User followed, User follower) {
		Optional<Link> optionaLink = linkRepository.findByFollowedIdFollowerId(followed.getId(), follower.getId());
		if (!optionaLink.isPresent()) {
			Link link = new Link(followed, follower);
			followed.getLinks().add(link);
			linkRepository.save(link);
		}
	}
	
}
