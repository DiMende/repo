package exceptions.password;

public class NoUpperAlphaException extends Exception {

	public NoUpperAlphaException() {
		super("Password must contain at least one uppercase alphabetic character");
	}

	

}
