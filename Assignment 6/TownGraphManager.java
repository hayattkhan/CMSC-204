
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface
{
	private Graph tmGraph;
	
	public TownGraphManager()
	{
		tmGraph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) 
	{
		if (tmGraph.addEdge(new Town(town1), new Town(town2), weight, roadName) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public String getRoad(String town1, String town2) 
	{
		return tmGraph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	@Override
	public boolean addTown(String v) 
	{
		return tmGraph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) 
	{
		for(Town currentTown : tmGraph.vertexSet())
		{
			if(name.equals(currentTown.getName()))
			{
				return currentTown;
			}
		}
		
		return null;
	}

	@Override
	public boolean containsTown(String v) 
	{
		for(Town town : tmGraph.vertexSet())
		{
			if(town.getName().equals(v))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) 
	{
		return tmGraph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() 
	{
		ArrayList<String> roadsArray = new ArrayList<String>();
		for(Road road : tmGraph.edgeSet())
		{
			roadsArray.add(road.getName());
		}
		
		Collections.sort(roadsArray);
		
		return roadsArray;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) 
	{
		if(tmGraph.removeEdge(new Town(town1), new Town(town2), -1, road) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean deleteTown(String v) 
	{
		return tmGraph.removeVertex(new Town(v));
	}

	@Override
	public ArrayList<String> allTowns() 
	{
		ArrayList<String> townsArray = new ArrayList<String>();
		for(Town town : tmGraph.vertexSet())
		{
			townsArray.add(town.getName());
		}
		
		Collections.sort(townsArray);
		
		return townsArray;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) 
	{
		ArrayList<String> pathArray = tmGraph.shortestPath(new Town(town1), new Town(town2));
		if(String.join(" ", pathArray).contains("placeholder"))
		{
			return new ArrayList<String>();
		}
		else
		{
			return pathArray;
		}
	}
	
	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException
	{
		Scanner inputScanner = new Scanner(selectedFile);
		
		while(inputScanner.hasNextLine())
		{
			String[] dataLinesArray = inputScanner.nextLine().split(";");
			Town source = new Town(dataLinesArray[1]);
			Town destination = new Town(dataLinesArray[2]);
			
			tmGraph.addVertex(source);
			tmGraph.addVertex(destination);
			dataLinesArray = dataLinesArray[0].split(",");
			tmGraph.addEdge(source, destination, Integer.parseInt(dataLinesArray[1]), dataLinesArray[0]);
		}
	}

}
