package exceptions.notation;

/**
 * @author Diego Mendez
 */
public class QueueOverflowException extends RuntimeException {
	
	public QueueOverflowException() {
		super("queue is full");
	}

}
