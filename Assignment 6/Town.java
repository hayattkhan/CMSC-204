
import java.util.ArrayList;

public class Town implements Comparable<Town>
{
	private String townName;
	private ArrayList<Town> tempTown;
	
	public Town(String name)
	{
		this.townName = name;
	}
	public Town(Town templateTown)
	{
		townName = templateTown.getName();
		tempTown = templateTown.tempTown;
	}
	
	public String getName()
	{
		return townName;
	}
	
	public int hashCode()
	{
		int primeNumber = 31;
		int result = 1;
		
		if(townName == null)
		{
		    result = primeNumber * result;
		}
		else
		{
		    result = primeNumber * result + townName.hashCode();
		}
		
		return result;
	}
	
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(getClass() != obj.getClass())
		{
			return false;
		}

		Town anotherTown = (Town)obj; //cast
		
		if(townName.equals(null)) 
		{
			if(anotherTown.townName != null)
			{
				return false;
			}
		} 
		if(!townName.equals(anotherTown.townName))
		{
			return false;
		}

		return true;
	}
	
	@Override
	public int compareTo(Town o) 
	{
		return townName.compareTo(o.getName());
	}
	
	public String toString()
	{
		return townName;
	}
}
