//package application;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> 
{
	Comparator<T> myComparator;
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject)
	{
		super();
		myComparator = compareableObject;
	}
	
	public void add​(T data)
	{
		Node node = new Node(data);
		Node currentNode = heads;
		boolean accepted = false;
		boolean continueFlag = true;
		T presentData;
		
		if(heads == null)
		{
			accepted = true;
			heads = node;
			tails = node;
		}
		else
		{
			while(continueFlag)
			{
				presentData = currentNode.data;
				
				if(myComparator.compare(data, presentData) < 0)
				{
					accepted = true;
					
					if(heads == currentNode)
					{
						currentNode.previous = node;
						node.next = currentNode;
						heads = node;
					}
					else
					{
						node.next = currentNode;
						node.previous = currentNode.previous;
						currentNode.previous.next = node;
						currentNode.previous = node;
					}
					
					continueFlag = false;
				}
				else if(currentNode.next != null)
				{
					currentNode = currentNode.next;
				}	
				else
				{
					continueFlag = false;;
				}
			}
			
			if (!accepted)
			{
				currentNode.next = node;
				node.previous = tails;
				tails = node;
			}
		}
		
		++size;
	}
	
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}

	public Node remove​(T data, Comparator<T> comparator)
	{
		return super.remove​(data, comparator);
	}
	
	//don't do these remaining methods
	public void addToEnd​(T data) throws java.lang.UnsupportedOperationException
	{
		throw new java.lang.UnsupportedOperationException("Invalid operation for sorted list");
	}
	public void addToFront​(T data) throws java.lang.UnsupportedOperationException
	{
		throw new java.lang.UnsupportedOperationException("Invalid operation for sorted list");
	}
	
}
