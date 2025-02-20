package exceptions.password;

public class UnmatchedException extends RuntimeException {
	
	public UnmatchedException() {
		super("Passwords do not match");
	}
}
