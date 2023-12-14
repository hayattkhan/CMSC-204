

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>
{
	private Set<Town> townsSet;
	private Set<Road> roadsSet;
	Map<Town, Road> shortMap;
	
	public Graph()
	{
		townsSet = new HashSet<Town>();
		roadsSet = new HashSet<Road>();
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex)
	{
		for(Road currentRoad : roadsSet)
		{
			if(currentRoad.contains(sourceVertex))
			{
				if(currentRoad.contains(destinationVertex))
				{
					return new Road(sourceVertex, destinationVertex, currentRoad.getWeight(), currentRoad.getName());
				}
			}
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		if(sourceVertex == null || destinationVertex == null)
		{
			throw new NullPointerException();
		}
		else if(!townsSet.contains(sourceVertex) || !townsSet.contains(destinationVertex))
		{
			throw new IllegalArgumentException();
		}

		Road newRoadEdge = new Road(sourceVertex, destinationVertex, weight, description);
		
		if(containsEdge(sourceVertex, destinationVertex))
		{
			return null;
		}

		roadsSet.add(newRoadEdge);
		
		return newRoadEdge;
	}

	@Override
	public boolean addVertex(Town v) 
	{
		int size = townsSet.size();
		townsSet.add(v);
		
		if(size != townsSet.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex)
	{
		for (Road currentRoad : roadsSet)
		{
			if(currentRoad.equals(new Road(sourceVertex, destinationVertex, "")))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsVertex(Town v)
	{
		for (Town currentTown : townsSet)
		{
			if(currentTown.equals(v))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Set<Road> edgeSet()
	{
		return roadsSet;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) 
	{
		if(vertex == null)
		{
			throw new NullPointerException();
		}
		else if(!townsSet.contains(vertex))
		{
			throw new IllegalArgumentException();
		}

		Set<Road> adjacentRoad = new HashSet<Road>();
		
		for(Road currentRoad : roadsSet)
		{
			if(currentRoad.contains(vertex))
			{
				adjacentRoad.add(currentRoad);
			}
		}
		
		return adjacentRoad;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description)
	{
		boolean checker;
		Road tempRoad;
		
		tempRoad = new Road(sourceVertex, destinationVertex, weight, description);
		for(Road currentRoad : roadsSet)
		{
			if(currentRoad.equals(tempRoad))
			{
				checker = true;
				
				if((weight > -1) && (currentRoad.getWeight() != weight))
				{
					checker = false;
				}
				
				if((description != null) && (!currentRoad.getName().equals(description)))
				{
					checker = false;
				}

				if (checker)
				{
					roadsSet.remove(currentRoad);
					return currentRoad;
				}
			}
		}
		
		return null;
	}

	@Override
	public boolean removeVertex(Town v)
	{
		int townsSize = townsSet.size();
		townsSet.remove(v);
		
		if(townsSize != townsSet.size())
		{
			Set<Road> roadsSetCopy = new HashSet<Road>();
			roadsSetCopy.addAll(roadsSet);
			
			for(Road currentRoad : roadsSetCopy)
			{
				if(currentRoad.contains(v))
				{
					removeEdge(currentRoad.getSource(), currentRoad.getDestination(), currentRoad.getWeight(), currentRoad.getName());
				}
			}
			
			return true;
		}
		
		return false;
	}

	@Override
	public Set<Town> vertexSet()
	{
		return townsSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex)
	{
		dijkstraShortestPath(sourceVertex);
		
		ArrayList<String> shortestArray = new ArrayList<String>();
		Town currentTown = destinationVertex;
		
		Road tempRoad;
		while(!currentTown.equals(sourceVertex))
		{
			tempRoad = shortMap.get(currentTown);
			shortestArray.add(0, tempRoad.getSource() + " via " + tempRoad.getName() + " to " + currentTown + " " + tempRoad.getWeight() + " mi");
			currentTown = tempRoad.getSource();
		}
		
		return shortestArray;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex)
	{
		shortMap = new HashMap<Town, Road>();
		
		for(Town tempTown : townsSet)
		{
			shortMap.put(tempTown, new Road(sourceVertex, tempTown, Integer.MAX_VALUE, "placeholder"));
		}

		Queue<Town> townQueue = new LinkedList<Town>();
		Set<Town> searchedTownsSet = new HashSet<Town>();
		
		shortMap.put(sourceVertex, new Road(sourceVertex, sourceVertex, 0, "reflexive"));
		townQueue.add(sourceVertex);
		searchedTownsSet.add(sourceVertex);
		
		while(townQueue.size() > 0) //algorithm
		{
			Town currentTown = townQueue.remove();
			
			for(Road currentRoad : roadsSet)
			{
				if(currentRoad.contains(currentTown))
				{
					Town sourceTown = currentTown;
					Town destinationTown;

					if(currentRoad.getSource().equals(currentTown))
					{
						destinationTown = currentRoad.getDestination();
					}
					else 
					{
						destinationTown = currentRoad.getSource();
					}

					if(!searchedTownsSet.contains(destinationTown))
					{
						townQueue.add(destinationTown);
						searchedTownsSet.add(destinationTown);
					}

					int crWeight = currentRoad.getWeight();
					
					Town temp = sourceTown;
					
					while(!temp.equals(sourceVertex))
					{
						crWeight += shortMap.get(temp).getWeight();
						temp = shortMap.get(temp).getSource();
					}
					
					int previous = 0;
					temp = destinationTown;
					
					while(!temp.equals(sourceVertex))
					{
						previous += shortMap.get(temp).getWeight();
						temp = shortMap.get(temp).getSource();
					}
					
					if(crWeight < previous)
					{
						shortMap.put(destinationTown, new Road(sourceTown, destinationTown, currentRoad.getWeight(), currentRoad.getName()));
					}
				}
			}
		}
	}
}
