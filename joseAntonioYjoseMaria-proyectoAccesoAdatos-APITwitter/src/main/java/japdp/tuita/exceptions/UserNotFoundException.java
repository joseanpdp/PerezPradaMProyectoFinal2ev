package japdp.tuita.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(long id) {
		super("User not found: id =" + id);
	}
	
	public UserNotFoundException(String name) {
		super("User not found: username = " + name);
	}
	
}