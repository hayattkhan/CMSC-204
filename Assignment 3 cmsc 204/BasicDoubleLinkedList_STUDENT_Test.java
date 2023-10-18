//package application;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedList_STUDENT_Test 
{
	BasicDoubleLinkedList<String> stringList;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		stringList = new BasicDoubleLinkedList<String>();
		stringList.addToEnd​("i");
		stringList.addToEnd​("am");
		stringList.addToFront​("Hello");
		stringList.addToEnd​("Jeff");
	}

	@AfterEach
	void tearDown() throws Exception 
	{
	}
	
	@Test
	void testArrayList() 
	{
		assertEquals(stringList.toArrayList().get(0), "Hello");
		assertEquals(stringList.toArrayList().get(1), "i");
		assertEquals(stringList.toArrayList().get(2), "am");
		assertEquals(stringList.toArrayList().get(3), "Jeff");
	}
	
	@Test
	void testRemove() 
	{
		assertEquals(stringList.toArrayList().get(0), "Hello");
		stringList.remove​("Hello", new ComparingStrings());
		assertEquals(stringList.toArrayList().get(0), "i");
	}
	
	@Test
	void testRetrieve()
	{
		assertEquals(stringList.retrieveFirstElement(), "Hello");
		assertEquals(stringList.retrieveLastElement(), "Jeff");
	}
	
	@Test
	void testAddToFront()
	{
		assertEquals(stringList.retrieveFirstElement(), "Hello");
		stringList.addToFront​("firstTest");
		assertEquals(stringList.retrieveFirstElement(), "firstTest");
	}
	
	@Test
	void testAddToEnd()
	{
		assertEquals(stringList.retrieveLastElement(), "Jeff");
		stringList.addToEnd​("lastTest");
		assertEquals(stringList.retrieveLastElement(), "lastTest");
	}
	
	private class ComparingStrings implements Comparator<String>
	{
		@Override
		public int compare(String a1, String a2) 
		{
			return a1.compareTo(a2);
		}
		
	}
	

}