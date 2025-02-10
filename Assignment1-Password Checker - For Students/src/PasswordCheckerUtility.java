
import java.lang.Object;
import java.util.ArrayList;

import exceptions.password.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/** A utility class that uses various password methods like {@code isValidLength}, {@code hasUpperAlpha}, {@code hasLowerAlpha}
 * {@code hasDigit​}, {@code hasSpecialChar​}, and {@code noSameCharInSequence​} to check if password meets each respective requirements. 
 * Class only throws one error per password, with {@code LengthException} being the first and {@code InvalidSequenceException} being last.
 * Imports exceptions.password to throw each special exception.
 * @author Diego Mendez
 * 
 */
/**
 * Using default constructor
 */
public class PasswordCheckerUtility {

    /**
     * checks if password is valid by serious of test
     * @param password - password of user
     * @return false - if password fails tests, true otherwise
     * @throws LengthException - if password is less than 6 characters
     * @throws NoUpperAlphaException - if password has no upper case alpha
     * @throws NoLowerAlphaException - if password has no lower case alpha
     * @throws NoDigitException - if password has no digit
     * @throws NoSpecialCharacterException - if password has no special character
     * @throws InvalidSequenceException - if password has 3 or more characters in a sequence
     */
	public static boolean isValidPassword (String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
			
		if(isValidLength(password) && hasDigit​(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasSpecialChar​(password)
			&& noSameCharInSequence(password))
			return true;
				
		return false;
	
	}
		
	/**
	 * checks if password is between 6 - 9 characters
	 * @param password - password of user
	 * @return false -  if password is not between 6 - 9 characters
	 * @throws WeakPasswordException - if password is between 6 - 9 characters
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		 
			 if(password.length() >= 6 && password.length() <= 9)
				throw new WeakPasswordException();
			 
			 return false;
			
	}

	/**
	 * checks array list of passwords to see which passwords are valid within the list
	 * @param passwords - the list of passwords from user
	 * @return array list of invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords (ArrayList<String>passwords){
		
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		String currPass = "";
	
		for(int i = 0; i < passwords.size();i++){
			currPass = passwords.get(i);	
			try {
					System.out.println(isValidPassword(currPass));
			} catch (LengthException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException
					| NoUpperAlphaException | NoLowerAlphaException e) {
				invalidPasswords.add(currPass + " " + e.getMessage());
			}			
		}
	
		return invalidPasswords;
	}
	/**
	 * checks if password matches with confirm password
	 * @param password - first password from user
	 * @param passwordConfirm - second password from user
	 * @throws UnmatchedException - if passwords do not match
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if(!password.equals(passwordConfirm))
			throw new UnmatchedException();
		
		
    }
	/**
	 * checks if password matches with confirm password
	 * @param password - first password from user
	 * @param passwordConfirm - second password from user
	 * @return true - if password matches passwordConfirm, false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm){
		
		if(password.equals(passwordConfirm))
			return true;
		return false;
		
	}
	/**
	 * checks if password is at least 6 characters in length
	 * @param password password of user
	 * @return true if password is at least 6 characters
	 * @throws LengthException if password is less than 6 characters
	 */
	public static boolean isValidLength(String password) throws LengthException{
		
		if(password.length() < 6){
			throw new LengthException();
		}
		return true;
	
	}
	
	/**
	 * checks if password has a upper case alpha
	 * @param password password of user
	 *@return true if password has at least one upper case alpha
	 *@throws NoUpperAlphaException if password does not have a upper case alpha
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		
		String upperAlpha = "ZXCVBNMASDFGHJKLQWERTYUIOP";
		
		
			
		for(int i = 0; i < password.length();i++) {
			if( upperAlpha.indexOf(password.substring(i,i+1)) != -1 ) {
				return true;
			}
		}
			
		throw new NoUpperAlphaException();
		 
	}
	/**
	 * checks if password has a lower case alpha
	 * @param password password of user
	 *@return true if password has at least one lower case alpha
	 *@throws NoLowerAlphaException if password does not have a lower case alpha
	 */
	private static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		String lowerAlpha = "zxcvbnmasdfghjklqwertyuiop";
		
	
			
		for(int i = 0; i < password.length();i++) {
			if( lowerAlpha.indexOf(password.substring(i,i+1)) != -1 ) {
				return true;
			}
		}
			
		throw new NoLowerAlphaException();
		
	}
	/**
	 * checks if password has a digit
	 *@param password password of user
	 *@return true if password has at least one digit
	 *@throws NoDigitException if password does not have a digit
	 */
	private static boolean hasDigit​(String password) throws NoDigitException {
		String digits = "1234567890";
		
	
			
		for(int i = 0; i < password.length();i++) {
			if( digits.indexOf(password.substring(i,i+1)) != -1 ) {
				return true;
			}
		}
			
		throw new NoDigitException();
	
	}
	/**
	 * checks if password has a special character
	 * @param password password of user
	 * @return true if password has at least one special character
	 * @throws NoSpecialCharacterException if password does not have a special character
	 */
	private static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException { 
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
			
		if(matcher.matches())
			throw new NoSpecialCharacterException();
			
		return true;
			 


		
	}
	/**
	 * checks if password has 3 or more characters in a sequence
	 *@param password password of user
	 *@return true if password has 2 or less characters in a sequence
	 *@throws InvalidSequenceException if password does have 3 or more characters in a sequence
	 */
	private static boolean noSameCharInSequence(String password) throws InvalidSequenceException{
		
	
		for(int i = 0; i < password.length()-2; i++) {
				
			if(password.charAt(i) == password.charAt(i+1) && password.charAt(i) == password.charAt(i+2))
				throw new InvalidSequenceException();
				
		}
			
		return true;
			

		
	}
	/**
	 * checks if password is between 6 - 9 characters
	 * @param password - password of user
	 * @return true if password is between 6 - 9 characters, false otherwise
	 */
	private static boolean hasBetweenSixAndNineChars​(String password) {
		
		
		if(password.length() >= 6 && password.length() <= 9) 
			return true;

		return false;
		
	}

}