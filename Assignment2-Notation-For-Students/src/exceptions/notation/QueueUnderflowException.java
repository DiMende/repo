package exceptions.notation;
/**
 * @author Diego Mendez
 */
public class QueueUnderflowException extends RuntimeException {
	
	public QueueUnderflowException() {
		
		super("Queue is empty");
		
	}

}
