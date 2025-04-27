import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverter_STUDENT_Test {

	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
		assertEquals("hello world",converter1);
	}
	
	@Test
	public void testConvertMorseStringToEnglishString() {	
		
		String converter1 = MorseCodeConverter.convertToEnglish("- .... . / --.- ..- .. -.-. -.- / -... .-. --- .-- -. / ..-. --- -..- / .--- ..- -- .--. ... / --- ...- . .-. / - .... . / .-.. .- --.. -.-- / -.. --- --.");
		assertEquals("the quick brown fox jumps over the lazy dog", converter1);
		//Student Test
		String spanishQuote = MorseCodeConverter.convertToEnglish("-- .. . -. - .-. .- ... / ..- -. --- / . ... - .- / ...- .. ...- --- / ..- -. --- / -.. . -... . / .- -- .- .-. / .-.. --- / -- .- ... / --.- ..- . / .--. ..- . -.. .-");
		assertEquals("mientras uno esta vivo uno debe amar lo mas que pueda",spanishQuote);
		
		
	}
	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		File file = new File("src/DaisyDaisy.txt"); 
		try {
			assertEquals(("IM HALF CRAZY ALL FOR THE LOVE OF YOU").toLowerCase(), MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File secondFile = new File("src/DaisyDaisy.txt"); 
		try {
			assertEquals(("IM HALF CRAZY ALL FOR THE LOVE OF YOU").toLowerCase(), MorseCodeConverter.convertToEnglish(secondFile));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		File thirdFile = new File("src/Daisy.txt"); 
		try {
			assertEquals("GIVE ME YOUR ANSWER DO".toLowerCase(), MorseCodeConverter.convertToEnglish(thirdFile));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		//Student test with new file
		File fourthFile = new File("src/LoveLooksNot.txt");
		try {
			assertEquals("LOVE LOOKS NOT WITH THE EYES BUT WITH THE MIND".toLowerCase(), MorseCodeConverter.convertToEnglish(fourthFile));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		//non-student file
		
		File fifthFile = new File("src/DtMF.txt");
		try {
			assertEquals("debi tirar mas fotos de cuando te tuve", MorseCodeConverter.convertToEnglish(fifthFile));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
		
	}

}
