package exceptions.password;

public class NoLowerAlphaException extends Exception {
	
	public NoLowerAlphaException() {
		super("Password must contain at least one lowercase alphabetic character");
	}
}
