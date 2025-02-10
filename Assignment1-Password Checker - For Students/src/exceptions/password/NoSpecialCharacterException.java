package exceptions.password;

public class NoSpecialCharacterException extends RuntimeException {
	
	public NoSpecialCharacterException(){
		super("Password must contain at least one special character");
	 }


}
