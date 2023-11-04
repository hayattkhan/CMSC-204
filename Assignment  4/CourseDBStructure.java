
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface 
{
	private LinkedList hasingTable[];
	private int spaceLength;
	
	public CourseDBStructure(int number)
	{
		spaceLength = (int)((number/1.5) + 6);
		
		while(!isPrime(spaceLength)) 
		{
			spaceLength++;
		}
		
		hasingTable = new LinkedList[spaceLength];
	}
	
	public CourseDBStructure(String test, int size)
	{
		spaceLength = size;
		hasingTable = new LinkedList[size];
	}
	
	@Override
	public void add(CourseDBElement element) 
	{
		int binded = String.valueOf(element.getCRN()).hashCode() % spaceLength;
		
		hasingTable[binded] = new LinkedList<CourseDBElement>();

		if(!(hasingTable[binded] == null))
		{
			if(!(hasingTable[binded].contains(element)))
			{
				hasingTable[binded].add(element);
			}
		}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException 
	{
		int current = String.valueOf(crn).hashCode() % spaceLength;
		
		if(hasingTable[current] == null)
		{
			throw new IOException();
		}

		for(int index = 0; index < hasingTable[current].size(); index++)
		{
			CourseDBElement tempElement = (CourseDBElement)hasingTable[current].get(index);
			
			if(tempElement.getCRN() == crn) 
			{
				return tempElement;
			}
		}
		//if not found in bucket, throw exception
		throw new IOException();
	}

	@Override
	public ArrayList<String> showAll() 
	{
		ArrayList<String> returningAL = new ArrayList<>();
		CourseDBElement tempElement;
		
		for(int index = 0; index < hasingTable.length; index++)
		{
			if(!(hasingTable[index] == null))
			{
				for(int index2 = 0; index2 < hasingTable[index].size(); index2++)
				{
					tempElement = (CourseDBElement)hasingTable[index].get(index2);
					returningAL.add("\nCourse:" + tempElement.getID() + " " + "CRN:" + tempElement.getCRN() + " " + "Credits:" + tempElement.getCredits() + " " + "Instructor:" + tempElement.getInstructorName() + " " + "Room:" + tempElement.getRoomNum());
				}
			}
		}
		
		return returningAL;			
	}

	@Override
	public int getTableSize() 
	{
		return spaceLength;
	}
	
	//primer checker
	public static boolean isPrime(int numberToCheck) 
	{      
		if(1 >= numberToCheck)
		{
			return false;
		}

		for(int index = 2; index <= Math.sqrt(numberToCheck); index++)
		{
			if(numberToCheck % index == 0)
			{
				return false;
			}
		}

		return true; 
	}
}
