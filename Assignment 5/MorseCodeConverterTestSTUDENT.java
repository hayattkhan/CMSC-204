/**
 * @author hayatullahkhan
 */


import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTestSTUDENT 
{

	MorseCodeTree tree;
	ArrayList<String> studentArray;
	@BeforeEach
	void setUp() throws Exception 
	{
		tree = new MorseCodeTree();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		tree = null;
		studentArray = null;
	}

	@Test
	void test() 
	{
		studentArray = tree.toArrayList();
		assertEquals(studentArray.get(0), "h");
		assertEquals(studentArray.get(1), "s");
		assertEquals(studentArray.get(2), "v");
		assertEquals(studentArray.get(3), "i");
		assertEquals(studentArray.get(studentArray.size()-1), "o");
		assertEquals(tree.fetch("."), "e");
		tree.setRoot(new TreeNode<String>(""));
		assertEquals(tree.toArrayList().size(), 1);
		
	}
	
	@Test
	public void testConvertToEnglish() 
	{
		String phrase1=MorseCodeConverter.convertToEnglish​(".... .. / -- -.-- / -. .- -- . / .. ... / --- ... -.-. .- .-.");
		String phrase2=MorseCodeConverter.convertToEnglish​(".. / .... --- .--. . / - .... .. ... / .-- --- .-. -.- ...");
		assertEquals("hi my name is oscar",phrase1);
		assertEquals("i hope this works",phrase2);
	}
	
	@Test
	public void testToConvertEnglishFile() throws FileNotFoundException 
	{
		File file1=new File("src/Daisy.txt");
		File file2=new File("src/DaisyDaisy.txt");
		File file3=new File("src/LoveLooksNot.txt");
		assertEquals("give me your answer do",MorseCodeConverter.convertToEnglish​(file1));
		assertEquals("im half crazy all for the love of you",MorseCodeConverter.convertToEnglish​(file2));
		assertEquals("love looks not with the eyes but with the mind",MorseCodeConverter.convertToEnglish​(file3));
	}

}
