
import java.util.Arrays;

public class Road implements Comparable<Road>
{
	private Town[] ePoints;
	private int weight;
	private String roadName;
	
	public Road(Town source, Town destination, int degrees, String name)
	{
		ePoints = new Town[2];
		ePoints[0] = source;
		ePoints[1] = destination;
		weight = degrees;
		this.roadName = name;
	}
	public Road(Town source, Town destination, String name)
	{
		this(source, destination, 1, name);
	}	
	
	// Getters and setters
		public Town getSource()
		{
			return ePoints[0];
		}
		
		public Town getDestination()
		{
			return ePoints[1];
		}

		public int getWeight()
		{
			return weight;
		}

		public String getName()
		{
			return roadName;
		}
		
		public int compareTo(Road o)
		{
			return roadName.compareTo(o.getName());
		}
		
		public boolean contains(Town town)
		{
			if(ePoints[0].equals(town) || ePoints[1].equals(town))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public boolean equals(Object r)
		{
			Road road2 = (Road)r;
			
			if(road2.contains(ePoints[0]))
			{
				if(road2.contains(ePoints[1]))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}

		@Override
		public String toString() 
		{
			return "Road [endpoints=" + Arrays.toString(ePoints) + ", weight=" + weight + ", name=" + roadName + "]";
		}
}
