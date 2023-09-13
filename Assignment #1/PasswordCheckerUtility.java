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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility 
{
	public PasswordCheckerUtility()
	{	
	}
	
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
	{
		if(!password.equals(passwordConfirm))
		{
			throw new UnmatchedException();
		}
	}
	
	//Compare equality of two passwords
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		if(password.equals(passwordConfirm))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		int passLength = password.length();
		
		if((passLength <= 9) && (passLength >= 6))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Checks the password Digit requirement - Password must contain a numeric character
	public static boolean hasDigit(String password)throws NoDigitException
	{
		int passLength = password.length();
		boolean hasNumber = false;
		
		for(int index = 0; (index < passLength) && (!hasNumber); index++)
		{
			if(Character.isDigit(password.charAt(index)))
			{
				hasNumber = true;
			}
		}
		
		if(hasNumber == false)
		{
			throw new NoDigitException();
		}
		else
		{
			return hasNumber;	
		}
	}
	
	//Checks the password lower case requirement - Password must contain a lower case alpha character
	public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException
	{
		int passLength = password.length();
		boolean hasLowerCaseLetter = false;
		
		for(int index = 0; (index < passLength) && (!hasLowerCaseLetter); index++)
		{
			if(Character.isLowerCase(password.charAt(index)))
			{
				hasLowerCaseLetter = true;
			}
		}
		
		if(hasLowerCaseLetter == false)
		{
			throw new NoLowerAlphaException();
		}
		else
		{
			return hasLowerCaseLetter;	
		}
	}
	
	//Checks the password alpha character requirement - Password must contain an upper case alpha character
	public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException
	{
		int passLength = password.length();
		boolean hasUpperCaseLetter = false;
		
		for(int index = 0; (index < passLength) && (!hasUpperCaseLetter); index++)
		{
			if(Character.isUpperCase(password.charAt(index)))
			{
				hasUpperCaseLetter = true;
			}
		}
		
		if(hasUpperCaseLetter == false)
		{
			throw new NoUpperAlphaException();
		}
		else
		{
			return hasUpperCaseLetter;	
		}
	}

	//Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	public static boolean hasSameCharInSequence(String password)throws InvalidSequenceException
	{
		int passLength = password.length();
		boolean hasDuplicateMoreThanTwice = false;
		
		for(int index = 0; (index < passLength) && (!hasDuplicateMoreThanTwice); index++)
		{
			int counter = 0;
			for(int index2 = 0; index2 < passLength; index2++)
			{
				if(password.charAt(index) == password.charAt(index2))
				{
					counter++;
				}
			}
			if(counter > 2)
			{
				hasDuplicateMoreThanTwice = true;
			}
		}
		
		if(hasDuplicateMoreThanTwice == true)
		{
			throw new InvalidSequenceException();
		}
		else
		{
			return hasDuplicateMoreThanTwice;	
		}
	}
	
	//Checks the password SpecialCharacter requirement - Password must contain a Special Character
	public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException
	{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		
		if((!matcher.matches()))
		{
			return (!matcher.matches());
		}
		else
		{
			throw new NoSpecialCharacterException();
		}
	}
	
	//Checks the password length requirement - – The password must be at least 6 characters long
	public static boolean isValidLength(String password)throws LengthException
	{
		if(password.length() >= 6)
		{
			return true;
		}
		else
		{
			throw new LengthException();
		}
	}
	
	//Return true if valid password (follows all rules from above), returns false if an invalid password
	public static boolean isValidPassword(String password)
			throws LengthException,
            NoUpperAlphaException,
            NoLowerAlphaException,
            NoDigitException,
            NoSpecialCharacterException,
            InvalidSequenceException
	{
		if(!isValidLength(password))
		{
			throw new LengthException();
		}
		else if(!hasUpperAlpha(password))
		{
			throw new NoUpperAlphaException();
		}
		else if(!hasLowerAlpha(password))
		{
			throw new NoLowerAlphaException();
		}
		else if(!hasDigit(password))
		{
			throw new NoDigitException();
		}
		else if(!hasSpecialChar(password))
		{
			throw new NoSpecialCharacterException();
		}
		else if(hasSameCharInSequence(password))
		{
			throw new InvalidSequenceException();
		}
		else
		{
			return true;
		}
	}
	
	//Checks if password is valid but between 6 -9 characters
	public static boolean isWeakPassword(String password)throws WeakPasswordException
	{
		if(hasBetweenSixAndNineChars(password))
		{
			throw new WeakPasswordException();
		}
		else
		{
			return false;
		}
		
	}
	
	//Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		
		for(int index = 0; index < passwords.size(); index++)
		{
			try
			{
				isValidPassword(passwords.get(index));
			}
			catch(Exception e)
			{
				invalidPasswords.add(passwords.get(index) + " " + e.getMessage()); 
			}
		}
			
		return invalidPasswords;
	}
	
	/*
	public static void main(String[] args) throws LengthException
	{
		//testing purposes 
	}
	*/
}
