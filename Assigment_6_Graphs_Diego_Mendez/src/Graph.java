import java.util.*;

/**
 * @author Diego Mendez
 * Graph implements GraphInterface with
 * town and road as its generic objects
 * This graph is used for a town and road map and is implemented by
 * arrayList and nodes
 * Has two attributes:
 * -graphList: a arrayList of nodes that has each node point to another node that a town
 * is connected to through a road.
 * 
 */
public class Graph implements GraphInterface<Town,Road>{
	
	private ArrayList<Node> graphList;


	/**
	 * creates a new arrayList to be used as a graph representation of towns 
	 * and roads. 
	 */
	public Graph() {
		graphList = new ArrayList<Node>();
	}
	
	/**
	 * private class node uses three attributes to store data for the graph representation:
	 * -town the town that the node represent
	 * -road the road that connects the outter town node with the inner town node
	 * -next points to the next town in the arraylist
	 */
	private class Node{
		Town town;
		Road road;
		Node next;
		
		public Node(Town t) {
			this(t,null);
		}
		
		public Node(Town t,Road r) {
			this(t,r,null);
		}
		
		public Node(Town t,Road r, Node n) {
			town = t;
			road = r;
			next = n;
		}
		
	}

	/**
	 * This method retreves the edge/road that is connects to both the sourceVertex/town
	 * and the destinationVertex/town.
	 * @param sourceVertex the first town that the road is connect to 
	 * @param destinationVertex the second town that the road is connect to
	 * @return the road that connects both towns, null if the road does not exist in the current graph
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		int i = 0;
		
		while(sourceVertex.compareTo(graphList.get(i).town) != 0 && i < graphList.size())
			i++;
		Node currNode = graphList.get(i);
		while(currNode.next != null) {
			currNode = currNode.next;
			if( destinationVertex.equals(currNode.town))
				return currNode.road;
		}
		
		return null;
		
	}
	
	/**
	 * calls the getEdge method and passes in the two parameters to fetch the road that connects to 
	 * both towns. If there is such a road, then the getEdge method will return some road and the contains method
	 * will return true. If there is no such road, then null is returned by the getEdge method and 
	 * the containEdge method returns false.
	 * @return true if getEdge does not return null, false otherwise
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return getEdge(sourceVertex,destinationVertex) != null;
	}

	/**
	 * Iterates through the graphList finding both the source vertex and the destination vertex in the graph using a
	 * while loop.
	 * if both towns exits in the graph, then an edge/road is created that has all the attributes of
	 * the parameters and is added to the sourceVertex linked list. Returns the newly made road.
	 * 
	 * @param sourceVertex the source town of the road
	 * @param destinationVertex the destination town of the road
	 * @param weight the length of the road
	 * @param description the name of the road
	 * @throws IllegalArgumentException if either the sourceVertex or the destinationVertex does not exist in the list
	 * @throws NullPointerException if sourceVertex or destinationVertex is null.
	 * @return newRoad the newly made road that was created using parameter. 
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description)  throws IllegalArgumentException,NullPointerException {
		
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) 
			throw new IllegalArgumentException();
		if(sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();
		
		
		int i = 0;
		int j = 0;
		
		while( i < graphList.size() && !sourceVertex.equals(graphList.get(i).town) )
			i++;
		while( j < graphList.size() && !destinationVertex.equals(graphList.get(j).town) )
			j++;
		
		
		Road newRoad = new Road(sourceVertex,destinationVertex,weight,description);
		Node newNode = new Node(destinationVertex,newRoad);
		
		if(graphList.get(i).next != null) 
			newNode.next = graphList.get(i).next;
		graphList.get(i).next = newNode;
		
		return newRoad;
		
	}

	/**
	 * adds the parameter town to the graph list, if it already exists in the graph list, then false is return.
	 * if the parameter town is not in the graph list, then it is added and true is returned.
	 * @throws NullPointerException if parameter v is null
	 * @return true if the vertex was successfully added to the graph list, false otherwise
	 */
	@Override
	public boolean addVertex(Town v) throws NullPointerException{
		if(v == null)
			throw new NullPointerException();
		
		for(int i = 0;i<graphList.size();i++) {
			if(v.equals(graphList.get(i).town))
				return false;
		}
		
		graphList.add(new Node(v));
		
		return true;
	
		
		
	}

	
	/**
	 * goes through the list and retrieves the parameter town in the graph list, if it does not exist in the graph,
	 * then null is returned
	 * @param v the town that is being retrieved   
	 * @return town the town that is contained within the graph list 
	 */
	public Town getVertex(Town v) {
		for(int i = 0;i<graphList.size();i++) {
			if(v.equals(graphList.get(i).town))
				return graphList.get(i).town;
		}
			
		return null;
	}
	
	/**
	 * Calls getVertex method. If the vertex is in the graph, the getVertex method returns something and contains vertex
	 * returns true. Returns false if getVertex returns null, meaning the vertex is not in the graph.
	 * @param v the vertex that is being checked if it is in the graph.
	 * @return true if the parameter v is contained within the graph.
	 */
	@Override
	public boolean containsVertex(Town v) {
		return getVertex(v) != null;
	}

	

	/**
	 * goes through the graph list and each of the buckets to find the road that is going to be removed using a 
	 * for loop for the outter list, and a while loop to traverse the linked lists. returns null if the road
	 * was not removed.
	 * @param sourceVertex the source town of the road
	 * @param destinationVertex the destination town of the road
	 * @param weight the length of the road
	 * @param description the name of the road
	 * @return roadToBeRemoved the removed road  
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(!containsEdge(sourceVertex,destinationVertex))
			return null;
		
		Road roadToBeRemoved = new Road(sourceVertex,destinationVertex,weight,description);
		Node currNode = null;
		Node prevNode = null;
		
		for(int i = 0; i < graphList.size();i++) {
			currNode = graphList.get(i);
			prevNode = currNode;
			while(currNode.next != null) {
				prevNode = currNode;
				currNode = currNode.next;
				if(currNode.road.compareTo(roadToBeRemoved) == 0) {
					prevNode.next = currNode.next;
					return roadToBeRemoved;
				}
					
			}
		}
		
		return null;
	}

	/**
	 * goes through the list using a for loop and a inner while loop to check each linked list in graphList
	 * to remove all instances of the vertex.
	 * @return true if the vertex was successfully removed, false otherwise.
	 */
	@Override
	public boolean removeVertex(Town v) {
		Node currNode = null;
		Node prevNode = null;
		boolean removed = false;
		
		for(int i = 0;i<graphList.size();i++) {
			currNode = graphList.get(i);
			
			if(currNode.town.equals(v)) {
				graphList.remove(i);
				removed = true;
			}else {
				while(currNode.next != null) {
					prevNode = currNode;
					currNode = currNode.next;
					if(currNode.town.equals(v)) {
						prevNode.next = currNode.next;
						removed = true;
					}
					
				}
			}
			
			
		}
		
		return removed;
	}
	
	/**
	 * returns the node that has the parameter vertex.
	 * @param v the town vertex
	 * @return the node that has the town vertex
	 */
	private Node getNodeV(Town v) {
		for(int i = 0;i<graphList.size();i++) {
			if(v.equals(graphList.get(i).town))
				return graphList.get(i);
		}
			
		return null;
	}


	/**
	 * Could not implement the method in time
	 * @param sourceVertex the source vertex
	 * @param destinationVertex the destination vertex
	 * @return null because the method was not implemented
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		return null;
	}

	/**
	 * This method uses the implementation from the class video, where there is both a closed set, a set
	 * of all vertices that the shortest path has been found, and a open set, the set of vertices of which the shortest 
	 * path has yet to be found. 
	 * @param sourceVertex the source town that the Dijkstra graph expands from
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Set<Node> open = new HashSet<>();
		Set<Node> closed = new HashSet<>();
		Set<Town> townSet = vertexSet();
		for(Town t:townSet)
			open.add(getNodeV(t));
		closed.add(getNodeV(sourceVertex));
		while(!open.isEmpty()) {
			int minWeight = Integer.MAX_VALUE;
			Node minAdjTown = null;
			for(Node town: closed) {
				for(Node adjTown: getAdjVerticesInSet(town.town,open)) {
					int weight = getWeightToSource(adjTown.town,town.town,sourceVertex);
					if(weight < minWeight) {
						minWeight = weight;
						minAdjTown = adjTown;
						adjTown.town.setBackPath(town.town);
					}
				}
			}
			
			if(minAdjTown != null) {
				minAdjTown.road.setWeight(minWeight);
				open.remove(minAdjTown);
				closed.add(minAdjTown);
			}
			
		}
		
	}
	
	/**
	 * returns the sum of the edge length from adjacent town to current town, and current town to source town.
	 * @param v1 the adjacent town 
	 * @param v2 the current town
	 * @param v3 the source town
	 * @return the sum of v1 to v2 and v2 to v3
	 */
	public int getWeightToSource(Town v1, Town v2, Town v3) {
		return getEdge(v2, v1).getWeight() + getEdge(v1,v3).getWeight();
	}
	
	/**
	 * Used to find the nodes adjacent to town v
	 * @param v the source town
	 * @param o a set of nodes 
	 * @return set of adjacent vertices from town v
	 */
	public Set<Node> getAdjVerticesInSet(Town v, Set<Node> o){
		Set<Node> adjSet = new HashSet<Node>();
		Node outter = this.getNodeV(v);
		Node currNode = outter.next;
		while(outter.next != null)
			adjSet.add(currNode);
		return adjSet;
	}
	
	/**
	 * iterates through the entire graph using a for loop
	 * and an inner while loop for the linked lists to find each and every edge that is contained within the graph
	 * that connects to the vertex.
	 * @param vertex the vertex that is used to check each edge that it is connected to
	 * @return edgeSet a set of all the edges within the graph that connects to the specified vertex
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edgeSet = new HashSet<Road>();
		Node currNode = null;
		for(int i = 0; i < graphList.size();i++) {
			if(vertex.equals(graphList.get(i).town)) {
				currNode = graphList.get(i);
				while(currNode.next != null) {
					currNode = currNode.next;
					edgeSet.add(currNode.road);
				}
			}
		}
		return edgeSet;
	}
	
	/**
	 * goes through the entire graph array list and each linked list to add all edges into 
	 * edgeSet.
	 * @return edgeSet the set of all edges in the graph
	 */
	@Override
	public Set<Road> edgeSet() {
		Set<Road> edgeSet = new HashSet<Road>();
		Node currNode = null;
		for(int i = 0;i<graphList.size();i++) {
			currNode = graphList.get(i);
			while(currNode.next != null) {
				currNode = currNode.next;
				edgeSet.add(currNode.road);
			}
		}
		
		return edgeSet;
	}

	/**
	 * iterates through the graph and adds each vertex to the set.
	 * @return vertexSet the set of all vertices in the graph.
	 */
	@Override
	public Set<Town> vertexSet() {
		Set<Town> vertexSet = new HashSet<Town>();
		for(int i = 0;i<graphList.size();i++) {
			vertexSet.add( graphList.get(i).town );
		}
				
		return vertexSet;
	}

}
