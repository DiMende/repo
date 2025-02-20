
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.password.*;


/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Diego Mendez
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	private ArrayList<String> studentPasswords = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		studentPasswords.add("a1A#b1Bc1Cd1D");
		studentPasswords.add("334455BB#");
		studentPasswords.add("@AAAbb@123");
		studentPasswords.add("myPassword2");
		studentPasswords.add("4wardMarch#");
		studentPasswords.add("Im2cool4U#");
		studentPasswords.add("bertha22");
		
	}

	@After
	public void tearDown() throws Exception {
		studentPasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("1234567"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			assertTrue(true);
		} catch (NoSpecialCharacterException e) {
			assertTrue(true);
		} catch (InvalidSequenceException e) {
			assertTrue(true);
		} catch (NoUpperAlphaException e) {
			assertTrue(true);
		} catch (NoLowerAlphaException e) {
			assertTrue(true);
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("1234"));
		} catch (LengthException e) {
			assertTrue(true);
		} catch (NoDigitException e) {
			fail("Should have thrown LengthException ");
		} catch (NoSpecialCharacterException e) {
			fail("Should have thrown LengthException ");
		} catch (InvalidSequenceException e) {
			fail("Should have thrown LengthException ");
		} catch (NoUpperAlphaException e) {
			fail("Should have thrown LengthException ");
		} catch (NoLowerAlphaException e) {
			fail("Should have thrown LengthException ");
		}
		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("1234A567"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			assertTrue(true);
		} catch (NoSpecialCharacterException e) {
			assertTrue(true);
		} catch (InvalidSequenceException e) {
			assertTrue(true);
		} catch (NoUpperAlphaException e) {
			fail("Should have passed NoUpperAlphaException test ");
		} catch (NoLowerAlphaException e) {
			assertTrue(true);
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("1234567"));
		} catch (LengthException e) {
			fail("Should have thrown NoUpperAlphaException ");
		} catch (NoDigitException e) {
			fail("Should have thrown NoUpperAlphaException ");
		} catch (NoSpecialCharacterException e) {
			fail("Should have thrown NoUpperAlphaException ");
		} catch (InvalidSequenceException e) {
			fail("Should have thrown NoUpperAlphaException ");
		} catch (NoUpperAlphaException e) {
			assertTrue(true);
		} catch (NoLowerAlphaException e) {
			fail("Should have thrown NoUpperAlphaException ");
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("123a4A567"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			assertTrue(true);
		} catch (NoSpecialCharacterException e) {
			assertTrue(true);
		} catch (InvalidSequenceException e) {
			assertTrue(true);
		} catch (NoUpperAlphaException e) {
			fail("Should have passed NoUpperAlphaException test ");
		} catch (NoLowerAlphaException e) {
			fail("Should have passed NoLowerAlphaException test ");
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("1234A567"));
		} catch (LengthException e) {
			fail("Should have thrown NoLowerAlphaException ");
		} catch (NoDigitException e) {
			fail("Should have thrown NoLowerAlphaException ");
		} catch (NoSpecialCharacterException e) {
			fail("Should have thrown NoLowerAlphaException ");
		} catch (InvalidSequenceException e) {
			fail("Should have thrown NoLowerAlphaException ");
		} catch (NoUpperAlphaException e) {
			fail("Should have thrown NoLowerAlphaException ");
		} catch (NoLowerAlphaException e) {
			assertTrue(true);
		}
	}
	/**
	 * Test if the password has between 6 - 9 characters in length
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("das12#Fs"));
		} catch(WeakPasswordException e) {
			fail("Should have passed weak password test");
		}
		
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword("dass"));
		} catch(WeakPasswordException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("123$a4A567"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			assertTrue(true);
		} catch (NoSpecialCharacterException e) {
			assertTrue(true);
		} catch (InvalidSequenceException e) {
			fail("Should have passed InvalidSequenceException test ");
		} catch (NoUpperAlphaException e) {
			fail("Should have passed NoUpperAlphaException test ");
		} catch (NoLowerAlphaException e) {
			fail("Should have passed NoLowerAlphaException test ");
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("123334a#A567"));
		} catch (LengthException e) {
			fail("Should have thrown InvalidSequenceException ");
		} catch (NoDigitException e) {
			fail("Should have thrown InvalidSequenceException ");
		} catch (NoSpecialCharacterException e) {
			fail("Should have thrown InvalidSequenceException ");
		} catch (InvalidSequenceException e) {
			assertTrue(true);
		} catch (NoUpperAlphaException e) {
			fail("Should have thrown InvalidSequenceException ");
		} catch (NoLowerAlphaException e) {
			fail("Should have thrown InvalidSequenceException ");
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("eFk#$12aA"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			fail("Should have passed NoDigitException test ");
		} catch (NoSpecialCharacterException e) {
			assertTrue(true);
		} catch (InvalidSequenceException e) {
			fail("Should have passed InvalidSequenceException test ");
		} catch (NoUpperAlphaException e) {
			fail("Should have passed NoUpperAlphaException test ");
		} catch (NoLowerAlphaException e) {
			fail("Should have passed NoLowerAlphaException test ");
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("eFk#$aA"));
		} catch (LengthException e) {
			fail("Should have thrown NoDigitException ");
		} catch (NoDigitException e) {
			assertTrue(true);
		} catch (NoSpecialCharacterException e) {
			fail("Should have thrown NoDigitException ");
		} catch (InvalidSequenceException e) {
			fail("Should have thrown NoDigitException ");
		} catch (NoUpperAlphaException e) {
			fail("Should have thrown NoDigitException ");
		} catch (NoLowerAlphaException e) {
			fail("Should have thrown NoDigitException ");
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("e$4fK2M"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			fail("Should have passed NoDigitException test ");
		} catch (NoSpecialCharacterException e) {
			fail("Should have passed NoSpecialCharacterException test ");
		} catch (InvalidSequenceException e) {
			fail("Should have passed InvalidSequenceException test ");
		} catch (NoUpperAlphaException e) {
			fail("Should have passed NoUpperAlphaException test ");
		} catch (NoLowerAlphaException e) {
			fail("Should have passed NoLowerAlphaException test ");
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("53F4*fa"));
		} catch (LengthException e) {
			fail("Should have passed LengthException test ");
		} catch (NoDigitException e) {
			fail("Should have passed NoDigitException test ");
		} catch (NoSpecialCharacterException e) {
			fail("Should have passed NoSpecialCharacterException test ");
		} catch (InvalidSequenceException e) {
			fail("Should have passed InvalidSequenceException test ");
		} catch (NoUpperAlphaException e) {
			fail("Should have passed NoUpperAlphaException test ");
		} catch (NoLowerAlphaException e) {
			fail("Should have passed NoLowerAlphaException test ");
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the invalidPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(studentPasswords);
		assertEquals(invalidPasswords.size(),4);
		assertEquals(invalidPasswords.get(0), "334455BB# Password must contain at least one lowercase alphabetic character");
		assertEquals(invalidPasswords.get(1), "@AAAbb@123 Password cannot contain more than two of the same character in sequence");
		assertEquals(invalidPasswords.get(2), "myPassword2 Password must contain at least one special character");
		assertEquals(invalidPasswords.get(3), "bertha22 Password must contain at least one uppercase alphabetic character");
		
		
	}
	
}
