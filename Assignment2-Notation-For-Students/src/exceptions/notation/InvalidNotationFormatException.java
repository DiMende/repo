package exceptions.notation;
/**
 * @author Diego Mendez
 */
public class InvalidNotationFormatException extends RuntimeException {
	
	public InvalidNotationFormatException() {
		super("Notation format is incorrect");
	}
	
}
