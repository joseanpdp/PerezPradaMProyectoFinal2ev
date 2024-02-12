package japdp.tuita.exceptions;

public class PublicationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PublicationNotFoundException(long id) {
		super("Publication not found: id = " + id);
	}
	
}