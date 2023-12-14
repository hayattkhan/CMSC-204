
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManagerTestStudent 
{
	private TownGraphManagerInterface tgmInterf;
	private Graph graph;
	private String[] towns;
	  
	@Before
	public void setUp() throws Exception 
	{
		  graph = new Graph();
		  tgmInterf = new TownGraphManager();
		  towns = new String[5];
	}

	@After
	public void tearDown() throws Exception 
	{
		graph = null;
		tgmInterf = null;
		towns = null;
	}

	@Test
	public void student() 
	{
		for(int index = 0; index < 5; index++)
		  {
			  towns[index] = "Town_" + (index + 1);
			  graph.addVertex(new Town(towns[index]));
			  tgmInterf.addTown(towns[index]);
		  }
		graph.addEdge(new Town(towns[0]), new Town(towns[1]), 5, "Road_1");
		graph.addEdge(new Town(towns[0]), new Town(towns[2]), 1, "Road_2");
		graph.addEdge(new Town(towns[2]), new Town(towns[3]), 1, "Road_3");
		graph.addEdge(new Town(towns[3]), new Town(towns[4]), 1, "Road_4");
		graph.addEdge(new Town(towns[4]), new Town(towns[1]), 1, "Road_5");
		
		ArrayList<String> path = graph.shortestPath(new Town(towns[0]), new Town(towns[1]));
		assertEquals(path.get(0), "Town_1 via Road_2 to Town_3 1 mi");
		assertEquals(path.size(), 4);
		
		tgmInterf.addRoad(towns[0], towns[1], 5, "Road_1");
		tgmInterf.addRoad(towns[0], towns[2], 1, "Road_2");
		tgmInterf.addRoad(towns[2], towns[3], 1, "Road_3");
		tgmInterf.addRoad(towns[3], towns[4], 1, "Road_4");
		tgmInterf.addRoad(towns[4], towns[1], 1, "Road_5");
		
		path = tgmInterf.getPath(towns[0], towns[1]);
		assertEquals(path.get(0), "Town_1 via Road_2 to Town_3 1 mi");
		assertEquals(path.size(), 4);
	}
}