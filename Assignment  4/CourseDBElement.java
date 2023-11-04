

public class CourseDBElement implements Comparable<CourseDBElement>
{
	private String courseID;
	private int cRN;
	private int numberOfCredits;
	private String roomNumber;
	private String professorName;
	
	public CourseDBElement()
	{
		this(null, -1, -1, null, null);
	}
	
	public CourseDBElement(String courseID, int cRN, int numberOfCredits, String roomNumber, String professorName)
	{
		this.courseID = courseID;
		this.cRN = cRN;
		this.numberOfCredits = numberOfCredits;
		this.roomNumber = roomNumber;
		this.professorName = professorName;
	}
	
	public void setID(String courseID)
	{
		this.courseID = courseID;
	}
	public String getID()
	{
		return courseID;
	}
	
	public void setCRN(int cRN)
	{
		this.cRN = cRN;
	}
	public int getCRN()
	{
		return cRN;
	}

	public void setCredits(int numberOfCredits) 
	{
		this.numberOfCredits = numberOfCredits;
	}	
	public int getCredits()
	{
		return numberOfCredits;
	}

	public void setRoomNum(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	public String getRoomNum()
	{
		return roomNumber;
	}

	public void setInstructorName(String professorName)
	{
		this.professorName = professorName;
	}
	public String getInstructorName() 
	{
		return professorName;
	}
		
	@Override
	public int hashCode() 
	{
		int primeNumber = 31;
		int returningHash;
		
		returningHash = primeNumber * 1 + cRN;
		
		return returningHash;
	}
	
	@Override
	public int compareTo(CourseDBElement o) 
	{
		if(this.cRN == o.getCRN())
		{
			return 0;
		}
		if(this.cRN > o.getCRN())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
