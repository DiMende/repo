package exceptions.notation;

/**
 * @author Diego Mendez
 */
public class StackOverflowException extends RuntimeException {
	public StackOverflowException() {
		super("Stack is full");
	}
}
