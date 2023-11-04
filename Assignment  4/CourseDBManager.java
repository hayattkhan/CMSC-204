
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface
{
	CourseDBStructure dbs;
	
	public CourseDBManager()
	{
		dbs = new CourseDBStructure(19);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		dbs.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	@Override
	public CourseDBElement get(int crn) 
	{
		CourseDBElement tempGetter = null;
		
		try 
		{
			tempGetter = dbs.get(crn);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return tempGetter;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		Scanner fileIn =new Scanner(input);
		
		if(!input.exists())
		{
			throw new FileNotFoundException();
		}
		else
		{
			while(fileIn.hasNext())
			{
				CourseDBElement element = new CourseDBElement(fileIn.next(),fileIn.nextInt(),fileIn.nextInt(),fileIn.next(),fileIn.next());
				dbs.add(element);
				fileIn.nextLine();
			}
		}
	}

	@Override
	public ArrayList<String> showAll() 
	{
		return dbs.showAll();
	}
}
