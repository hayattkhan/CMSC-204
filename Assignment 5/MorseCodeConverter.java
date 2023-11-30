/**
 * @author hayatullahkhan
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter 
{
	private static MorseCodeTree mcTree;
	
	public MorseCodeConverter()
	{
		mcTree = new MorseCodeTree();
	}
	
	//printTree
	public static String printTree()
	{
		mcTree = new MorseCodeTree();
		String printingTree = "";
		ArrayList<String> tempList = mcTree.toArrayList();
		
		for(int index = 0; index < tempList.size(); index++)
		{
			printingTree += tempList.get(index) + " ";
		}
		
		return printingTree.substring(0, printingTree.length() - 1);
	}
	
	//convertToEnglish
	public static String convertToEnglish​(String code)
	{
		MorseCodeTree tempAddition = new MorseCodeTree();
		
		String[] words = code.trim().split(" ");
		String returningString = "";
		
		for(int index = 0; index < words.length; index++)
		{
			returningString += tempAddition.fetch(words[index]);
		}
		
		return returningString;
	}
	
	//convertToEnglish
	public static String convertToEnglish​(File codeFile) throws FileNotFoundException
	{
		Scanner input = new Scanner(codeFile);
		String text = input.nextLine();
		input.close();
		
		return convertToEnglish​(text);
	}
}
