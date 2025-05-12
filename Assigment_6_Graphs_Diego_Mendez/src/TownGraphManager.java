import java.util.*;
/**@author Diego Mendez
 * TownGraphManager implements TownGraphManagerInterface
 * A manager for the graph and implements each method using each graph method
 * has one attribute
 * -townGraph: the graph of the town
 */
public class TownGraphManager implements TownGraphManagerInterface{

	private Graph townGraph;
	
	/**
	 * initializes townGraph 
	 */
	public TownGraphManager() {
		townGraph = new Graph();
	}
	
	/**
	 * adds a new road to the graph using the four parameters and creating new town objects.
	 * @param town1 one of the towns that is connected to the road
	 * @param town2 the other town connected to the road
	 * @param weight the length of the road
	 * @param roadName the name of the road
	 * @return true if addRoad was successful, false otherwise.
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
		try {
			townGraph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}

	/**
	 * Retrieves the name of the road using townGraph.getEdge and creating new town objects.
	 * @param town1 name of the first town
	 * @param town2 name of the second town
	 * @return name of road
	 */
	@Override
	public String getRoad(String town1, String town2) {
		return townGraph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	/**
	 * adds a town to the graph using addVertex method, returns true if successful.
	 * @param v name of the town
	 * @return true if vertex was successfully added, false otherwise.
	 */
	@Override
	public boolean addTown(String v) {
		try {
			return townGraph.addVertex(new Town(v));
		}catch(Exception e) {
			return false;
		}
	}

	/**
	 * retrieves the town of the same name as the parameter by calling getVertex method and passing in a new
	 * town object with parameter name.
	 * @param name name of the town
	 * @return town the town with the same name if its in the graph 
	 */
	@Override
	public Town getTown(String name) {
		return townGraph.getVertex(new Town(name));
	}

	/**
	 * calls containsVertex method to check if the town with the same name as the string parameter is 
	 * in the graph
	 * @param v name of the town
	 * @return true if town is in the graph, false otherwise
	 */
	@Override
	public boolean containsTown(String v) {
		return townGraph.containsVertex(new Town(v));
	}

	/**
	 * calls containsEdge method to check if there is a road that connects to both towns 
	 * @param town1 one of the towns that is connected to the road
	 * @param town2 the other town connected to the edge
	 * @return true if there is a road that connects to both parameter towns
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return townGraph.containsEdge(new Town(town1),new Town(town2));
	}

	/**
	 * returns the array list of roads by using an edge set and placing each road into the array list.
	 * @return r1 an array list of all roads in the graph
	 */
	@Override
	public ArrayList<String> allRoads() {
		
		ArrayList<String> r1= new ArrayList<>();
		
		Set<Road> roads = townGraph.edgeSet();
		
		Iterator<Road> roadIter = roads.iterator();
		
		while(roadIter.hasNext())
			r1.add(roadIter.next().toString());
		
		return r1;
	}

	/**
	 * Deletes the road that connects both town1 and town2. 
	 * Checks if the edge was sucessfuly removed by checking if removeEdge returns null, if not, then 
	 * road was removed, if so then road was not removed.
	 * @param town1 one of the town that is connected to the road
	 * @param town2 other town that is connected to the road
	 * @param road name of the road
	 * @return true if road was successfully removed, false otherwise
	 * 
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);

		return townGraph.removeEdge(t1,t2, townGraph.getEdge(t1, t2).getWeight(), road) != null;
	}

	/**
	 * deletes the town from the graph through removeVertex method
	 * @param v the town that is going to be removed from the graph.
	 * @return true if town was removed, false otherwise.
	 */
	@Override
	public boolean deleteTown(String v) {
		return townGraph.removeVertex(new Town(v));
	}

	/**
	 * creates an array list of towns by calling vertexSet and adding each town in the set to an array list
	 * @return towns an array list of towns in the graph
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		
		Set<Town> setTowns = townGraph.vertexSet();
		
		for(Town t:setTowns)
			towns.add(t.toString());
		
		return towns;
	}

	/**
	 * calls shortestPath to create an array list that has the shortest path 
	 * from town1 to town2
	 * @param town1 the source town
	 * @param town2 the destination town
	 * @return the shortest path from town1 to town2
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return townGraph.shortestPath(new Town("town1"), new Town("town2"));
	}
	
}
