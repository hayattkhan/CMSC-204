//package application;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SortedDoubleLinkedList_STUDENT_Test 
{

	SortedDoubleLinkedList<Integer> intList;
	Integer a = 100;
	Integer b = 200;
	Integer c = 300;
	Integer d = 150;
	Integer e = 500;
	
	
	
	@BeforeEach
	void setUp() throws Exception 
	{
		intList = new SortedDoubleLinkedList<Integer>(new IntegerComparator());
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		intList = null;
	}

	@Test
	void testNextIterator() 
	{
		intList.add​(a);
		intList.add​(b);
		intList.add​(c);
		intList.add​(d);
		ListIterator<Integer> iterator = intList.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next(), 0.01);
		assertEquals(d, iterator.next(), 0.01);
		assertEquals(b, iterator.next(), 0.01);
		assertEquals(c, iterator.next(), 0.01);
		assertEquals(false, iterator.hasNext());
	}
	
	@Test
	void testPreviousIterator() 
	{
		intList.add​(a);
		intList.add​(b);
		intList.add​(c);
		intList.add​(d);
		ListIterator<Integer> iterator = intList.iterator();

		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next(), 0.01);
		assertEquals(d, iterator.next(), 0.01);
		assertEquals(b, iterator.next(), 0.01);
		assertEquals(c, iterator.next(), 0.01);
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(c, iterator.previous(), 0.01);
		assertEquals(b, iterator.previous(), 0.01);
		assertEquals(d, iterator.previous(), 0.01);
		assertEquals(a, iterator.previous(), 0.01);
		assertEquals(false, iterator.hasPrevious());
	}
	
	@Test
	void testIteratorExceptions() 
	{
		intList.add​(a);
		intList.add​(b);
		intList.add​(c);
		intList.add​(d);
		
		ListIterator<Integer> iterator = intList.iterator();
		
		try 
		{
			while(iterator.hasNext())
			{
				iterator.next();
			}
			//throws an exception
			iterator.next(); //never reached
			assertTrue(false, "Didn't throw an exception");
		}
		catch(NoSuchElementException e) 
		{
			assertTrue(true, "Threw the correct exception");
		}
		catch(Exception e) 
		{
			assertTrue(false, "Threw a different exception");
		}
		
		try 
		{
			while(iterator.hasPrevious())
			{
				iterator.previous();
			}
			iterator.previous();
			assertTrue(false, "Didn't throw an exception");
		}
		catch(NoSuchElementException e) 
		{
			assertTrue(true, "Threw the correct exception");
		}
		catch(Exception e) 
		{
			assertTrue(false, "Threw a different exception");
		}
		
		//Testing UnsupportedOperationException
		try 
		{
			iterator.nextIndex();
			assertTrue(false, "Didn't throw the right exception");
		}
		catch(java.lang.UnsupportedOperationException e) 
		{
			assertTrue(true, "Threw the right exception");
		}
	}

	@Test
	void testAddToEnd() {
		try 
		{
			intList.addToEnd​(e);
			assertTrue(false, "Didn't throw the correct exception");
		}
		catch(java.lang.UnsupportedOperationException e) {
			assertTrue(true, "Threw the correct exception");
		}
	}

	@Test
	void testAddToFront() 
	{
		try 
		{
			intList.addToFront​(e);
			assertTrue(false, "Didn't throw the correct exception");
		}
		catch(java.lang.UnsupportedOperationException e) 
		{
			assertTrue(true, "Threw the correct exception");
		}
	}

	@Test
	void testAdd() 
	{
		intList.add​(a);
		intList.add​(b);
		intList.add​(c);
		intList.add​(d);
	}

	@Test
	void testRemove() 
	{
		intList.add​(a);
		intList.add​(b);
		intList.add​(c);
		intList.add​(d);
		intList.add​(e);
		assertEquals(a, intList.getFirst(), 0.01);
		
		//real test
		ListIterator<Integer> iterator = intList.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(a, iterator.next(), 0.01);
		assertEquals(d, iterator.next(), 0.01);
		assertEquals(b, iterator.next(), 0.01);
		assertEquals(c, iterator.next(), 0.01);
		assertEquals(e, iterator.next(), 0.01);
	}
	
	private class IntegerComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer a1, Integer a2) 
		{
			return a1-a2;
		}
	}
}