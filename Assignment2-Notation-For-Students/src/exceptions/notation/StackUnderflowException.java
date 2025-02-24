package exceptions.notation;
/**
 * @author Diego Mendez
 */
public class StackUnderflowException extends RuntimeException {
	
	public StackUnderflowException() {
		super("Stack is empty");
	}
	
}
