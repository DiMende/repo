package exceptions.password;

public class InvalidSequenceException extends RuntimeException {

	public InvalidSequenceException(){
		super("Password cannot contain more than two of the same character in sequence");
	}
}
