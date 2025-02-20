package exceptions.notation;

public class QueueOverflowException extends RuntimeException {
	
	public QueueOverflowException() {
		super("queue is full");
	}

}
