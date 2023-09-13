/*
 * Class: CMSC204 
 * Instructor: Monshi
 * Description: application that checks for password. Certain rules are to 
 * be followed
 * 				
 * Due: 9/12/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Hayat Khan
*/

package application;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerUtilityTestStudent 
{
	ArrayList<String> passwords;
	String password1, password2;

	@BeforeEach
	void setUp() throws Exception 
	{
		passwords = new ArrayList<String>();
		passwords.add("HelloAjhn!2");
		passwords.add("test");
		passwords.add("LLLokayGreat");
		passwords.add("1111111111111");
		passwords.add("ok");
		passwords.add("hello");
		passwords.add("Hello");
		passwords.add("HelloAjhn!2");
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		passwords = null;
	}

	@Test
	void testComparePasswords() 
	{
		password1 = passwords.get(0);
		password2 = passwords.get(7);
		try 
		{
			PasswordCheckerUtility.comparePasswords(password1, password2);
		} 
		catch (UnmatchedException e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	void testComparePasswordsWithReturn() 
	{
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn(passwords.get(0), passwords.get(7)));
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn(passwords.get(6), passwords.get(5)));
	}

	@Test
	void testHasBetweenSixAndNineChars() 
	{
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(passwords.get(0)));
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(passwords.get(5)));
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars("has6ch"));
	}

	@Test
	void testHasDigit() 
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasDigit(passwords.get(1)));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		
		try
		{
			assertFalse(PasswordCheckerUtility.hasDigit("hasch"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		
		try
		{
			assertTrue(PasswordCheckerUtility.hasDigit("ok"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
	}

	@Test
	void testHasLowerAlpha() 
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(passwords.get(1)));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
		
		try
		{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("NO-LOWER"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
	}

	@Test
	void testHasUpperAlpha() 
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(passwords.get(1)));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
		
		try
		{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("ok"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
	}

	@Test
	void testHasSameCharInSequence() 
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence("nooo"));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",true);
		}
		
		try
		{
			assertFalse(PasswordCheckerUtility.hasSameCharInSequence(passwords.get(0)));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",false);
		}
	}

	@Test
	void testHasSpecialChar() 
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasSpecialChar("ok"));
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
		
		try
		{
			assertTrue(PasswordCheckerUtility.hasSpecialChar(passwords.get(0)));
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
	}

	@Test
	void testIsValidLength() 
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidLength("nope"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthException",true);
		}
		
		try
		{
			assertTrue(PasswordCheckerUtility.isValidLength(passwords.get(0)));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthException",true);
		}
	}

	@Test
	void testIsValidPassword() 
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("111"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException",false);
			System.out.println("line 49");
		}
		
		 try 
		 {
			assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(0)));
		 } 
		 catch (Exception e)
		 {
			assertTrue("Threw some exception",false);
			System.out.println("line 49");
	     }
		 
		 try 
		 {
	        assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(4)));
		 }
		 catch(LengthException e)
		 {
			assertTrue("Successfully threw a LengthException",true);
		 }
		 catch (Exception e)
		 {
			assertTrue("Threw some other exception besides LengthException",false);
			System.out.println("line 49");
	     }
		 
		 try 
		 {
	        assertTrue(PasswordCheckerUtility.isValidPassword(passwords.get(3)));
		 }
		 catch(NoUpperAlphaException e)
		 {
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		 }
		 catch (Exception e)
		 {
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		 }
	}

	@Test
	void testIsWeakPassword() 
	{
		//assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(passwords.get(0)));
		//assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(passwords.get(5)));
		//assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars("has6ch"));
		
		
		try
		{
			assertFalse(PasswordCheckerUtility.isWeakPassword(passwords.get(0)));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides WeakPasswordException",false);
		}
		
		try
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword("has6ch"));
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPasswordException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides WeakPasswordException",false);
		}
	}

	@Test
	void testGetInvalidPasswords() 
	{
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		//System.out.println(invalidPasswords);
		
		 String invalid1 = invalidPasswords.get(0);
	     assertTrue(invalid1.contains("test"));
	     assertTrue(invalid1.contains("The password must be at least 6 characters long"));
	     
	     String invalid2 = invalidPasswords.get(1);
	     assertTrue(invalid2.contains("LLLokayGreat"));
	     assertTrue(invalid2.contains("The password must contain at least one digit"));
	     
	     String invalid3 = invalidPasswords.get(2);
	     assertTrue(invalid3.contains("1111111111111"));
	     assertTrue(invalid3.contains("The password must contain at least one uppercase alphabetic character"));
	     
	     String invalid4 = invalidPasswords.get(3);
	     assertTrue(invalid4.contains("ok"));
	     assertTrue(invalid4.contains("The password must be at least 6 characters long"));
	     
	     String invalid5 = invalidPasswords.get(4);
	     assertTrue(invalid5.contains("hello"));
	     assertTrue(invalid5.contains("The password must be at least 6 characters long"));
	     
	     String invalid6 = invalidPasswords.get(5);
	     assertTrue(invalid6.contains("Hello"));
	     assertTrue(invalid6.contains("The password must be at least 6 characters long"));
	}
	
	@Test
	void testDoesNotHaveSameCharInSqeuence()
	{
		try
		{
			assertFalse(PasswordCheckerUtility.hasSameCharInSequence(passwords.get(0)));
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw a InvalidSequenceException",false);
		}	
	}
	
	@Test
	void testDoesNotHaveDigit()
	{
		try
		{
			assertFalse(PasswordCheckerUtility.hasDigit("hasch"));
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
	}
	
	@Test
	void testDoesNotHaveLowerAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("NONELOWER"));
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaException",true);
		}
	}
	
	@Test
	void testDoesNotHaveSpecialChar()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasSpecialChar("basic"));
		}
		catch(NoSpecialCharacterException e)
		{
			assertTrue("Successfully threw a NoSpecialCharacterException",true);
		}
	}
	
	@Test
	void testDoesNotHaveUpperAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("ok"));
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaException",true);
		}
	}
	
	@Test
	void testValidLength()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidLength(passwords.get(0)));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthException",true);
		}
	}

}
