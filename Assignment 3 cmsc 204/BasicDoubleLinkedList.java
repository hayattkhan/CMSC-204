//package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>
{
	protected Node heads;
	protected Node tails;
	protected int size;
	
	public BasicDoubleLinkedList()
	{
		heads = null;
		tails = null;
		size = 0;
	}
	
	public int getSize() 
	{
		return size;
	}
	
	public void addToEnd​(T data)
	{
		Node node = new Node(data);
		
		if(heads == null)
		{
			heads = node;
			tails = node;
			++size;
		}
		else
		{
			tails.next = node;
			node.previous = tails;
			tails = node;
			++size;
		}
	}
	
	public void addToFront​(T data)
	{
		Node node = new Node(data);
		
		if(heads == null)
		{
			heads = node;
			tails = node;
			++size;
		}
		else
		{
			heads.previous = node;
			node.next = heads;
			heads = node;
			++size;
		}
	}
	
	public T getFirst()
	{
		return heads.data;
	}
	
	public T getLast()
	{
		return tails.data;
	}
	
	@Override
	public ListIterator<T> iterator()
	{
		DoubleLinkedListIterator doubleNodeIterator = new DoubleLinkedListIterator();
		return doubleNodeIterator;
	}
	
	public BasicDoubleLinkedList.Node remove​(T targetData, Comparator<T> comparator)
	{
		Node temp = heads;
		
		if(temp == null)
		{
			return null;
		}
		else
		{
			while((comparator.compare(targetData, temp.data) == 0) == false)
			{
				temp = temp.next;
			}
			
			if(temp == heads)
			{
				heads = heads.next;
				--size;
				return temp;
			}
			else if(temp == tails)
			{
				tails = tails.previous;
				--size;
				return temp;
			}
			
			temp.previous = temp.next.previous;
			temp.next = temp.previous;
			--size;
			return temp;
		}
	}
	
	public T retrieveFirstElement()
	{
		if(size == 0)
		{
			return null;
		}
		
		T tempData = heads.data;
		
		if(size == 1)
		{
			heads = null;
			tails = null;
			return tempData;
		}
		else if(size ==2)
		{
			heads = tails;
			return tempData;
		}
		
		heads = heads.next;
		heads.previous = null;
		--size;
		
		return tempData;
	}
	
	public T retrieveLastElement()
	{
		if(size == 0)
		{
			return null;
		}
		
		T tempData = tails.data;
		
		if(size == 1)
		{
			heads = null;
			tails = null;
			return tempData;
		}
		else if(size ==2)
		{
			tails = heads;
			return tempData;
		}
		
		tails = tails.previous;
		tails.next = null;
		--size;
		
		return tempData;
	}
	
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> tempArrayList = new ArrayList<T>();
		ListIterator<T> tempListIterator = new DoubleLinkedListIterator();
		
		while(tempListIterator.hasNext())
		{
			tempArrayList.add(tempListIterator.next());
		}
		
		return tempArrayList;
	}
	
	
	
	//doubly node class
	class Node
	{
		protected T data;
		protected Node previous;
		protected Node next;
		
		public Node(T data)
		{
			this(data, null, null);
		}
		
		public Node(T data, Node previous, Node next)
		{
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}
	
	//generic double linked list iterator
	class DoubleLinkedListIterator implements ListIterator<T>
	{
		private Node currentNext;
		private Node currentPrevious;
		
		public DoubleLinkedListIterator()
		{
			currentNext = new Node(null, null, null);
			currentPrevious = new Node(null, null, null);
			
			currentNext.next = heads;
		}
	
		
		@Override
		public boolean hasNext() 
		{
			if(currentNext.next == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		@Override
		public T next()
		{
			if(hasNext() == false)
			{
				throw new NoSuchElementException("Invalid call for next(), there are no more elements next");
			}
			else
			{
				currentNext = currentNext.next;
				currentPrevious.previous = currentNext;
				
				return currentNext.data;
			}
		}

		@Override
		public boolean hasPrevious() 
		{
			if(currentPrevious.previous == null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		@Override
		public T previous() 
		{
			if(hasPrevious() == false)
			{
				throw new NoSuchElementException("Illegal call to previous(); no element ahead");
			}
			else
			{
				currentPrevious = currentPrevious.previous;
				currentNext.next = currentPrevious;
				
				return currentPrevious.data;
			}
		}

		//don't do these remaining methods
		@Override
		public int nextIndex() throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();// TODO Auto-generated method stub
		}

		@Override
		public int previousIndex() throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();// TODO Auto-generated method stub
		}

		@Override
		public void remove() throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();// TODO Auto-generated method stub
		}

		@Override
		public void set(T e) throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();// TODO Auto-generated method stub
		}

		@Override
		public void add(T e) throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();// TODO Auto-generated method stub
		}

	}
}