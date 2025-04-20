import java.io.*;
import java.util.*;
/**
 * a utility class that is used to convert files and 
 * Strings from morse code into its english translation by the morse code binary tree.
 * MorseCodeConverter only has one static attribute which is MCT that will
 * be the MorseCodeTree object to translate morse code into English. 
 * @author Diego Mendez
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree MCT = new MorseCodeTree();
	
	/**
	 * calls MCT to array method and stores the result 
	 * in an arraylist 
	 * @return tree the entire morse code tree 
	 */
	public static String printTree() {
		String tree = "";
		ArrayList<String> list = MCT.toArrayList();
		return String.join(" ", list);
	}
	
	/**
	 * splits code by "/" and stores in array called splitBySlash. the split by slash makes it so each word
	 * of the morse code is stored in an index of the array.  
	 * then splitBySpace and englTransl are both instantiated for later use in the for loops.
	 * the outter enhanced for loop splits the word into letters, which then the inner for loop calls MCT.fetch to
	 * translate the letter from morse code into english charaters. after the inner for loop translates the entire word,
	 * then outter loop concludes with englTransl adding a space for the next word in the sentence.
	 * Once the entire for loop is done, then englTransl is trimmed and returned back to the user.
	 * 
	 * 
	 * @param code the sentence in morse code
	 * @return englTransl the english translation of the morse code. 
	 */
	public static String convertToEnglish(String code) {
		String[] splitBySlash = code.split("/");
		
		String[] splitBySpace;
		String englTransl = "";
			
		
		for(String word:splitBySlash) {
			
			splitBySpace = word.trim().split(" ");
			
			for(String letter: splitBySpace) 
				englTransl += MCT.fetch(letter);
			
			englTransl += " ";
		}
		
		return englTransl.trim();
	}
	
	/**
	 * First checks if the file exists, if it doesnt, then FileNotFoundException is thrown.
	 * Then a Scanner object is used to read a file and convert each line of the file (if there are multiple)
	 * into the English translation by calling the convertToEnglish method on each line of the file.
	 * The resulting translation is then stored in englTransl which is trimmed and returned.
	 * @param codeFile the file that contains the sentence
	 * @return englTransl the english translation of the morse code that is in the file
	 * @throws FileNotFoundException if file does not exists 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		
		if(codeFile == null)
			throw new FileNotFoundException();
	
		String englTransl = "";
		Scanner fileReader = new Scanner(codeFile);
		while(fileReader.hasNext())
			englTransl += convertToEnglish(fileReader.nextLine()) + "\n";
		fileReader.close();
		return englTransl.trim();
		
	}
	
}
