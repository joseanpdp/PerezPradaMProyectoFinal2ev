package japdp.tuita.exceptions;

public class PublicationIncorrectAuthorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public PublicationIncorrectAuthorException(long id) {
		super("Publication not found: id = " + id);
	}
}
