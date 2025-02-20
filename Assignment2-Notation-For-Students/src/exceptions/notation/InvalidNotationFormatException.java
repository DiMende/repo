package exceptions.notation;

public class InvalidNotationFormatException extends RuntimeException {
	
	public InvalidNotationFormatException() {
		super("Notation format is incorrcet");
	}
	
}
