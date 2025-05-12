/**
 * @author Diego Mendez
 * Road implements comparable and acts as the edge in a graph of towns
 * Has four attributes:
 * -source: source town of the road 
 * -destination: destination town of the road 
 * -weight: length of the road
 * -roadName: name of the road
 */
public class Road implements Comparable<Road> {

    private Town source;
    private Town destination;
    private int weight;
    private String roadName;

    /**
     * creates a road object with source,destination, weight, and roadName parameters.
     * @param source source town of road
     * @param destination destination town of road 
     * @param weight length of the road
     * @param roadName name of the road
     */
    public Road(Town source, Town destination, int weight, String roadName) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.roadName = roadName;
    }

    /**
     * creates a road object with a default weight of 1.
     * @param source source town of road
     * @param destination destination town of road
     * @param roadName road name of road
     */
    public Road(Town source, Town destination, String roadName) {
        this.source = source;
        this.destination = destination;
        this.weight = 1;
        this.roadName = roadName;
    }
    /**
     * returns the name of the road
     * @return roadName name of the road
     */
    public String getName() {
        return roadName;
    }

    /**
     * checks if the town parameter connects to the road
     * @param t town parameter 
     * @return true if road destination or source town is equal to parameter, false
     * otherwise
     */
    public boolean contains(Town t) {
        return source.equals(t) || destination.equals(t);
    }
    
    /**
     * returns the destination of the road
     * @return destination the town destination
     */
    public Town getDestination() {
        return destination;
    }
    
    /**
     * returns the source town that the road is connected to
     * @return source the town source that the edge is connected to
     */
    public Town getSource() {
        return source;
    }
    
    /**
     * returns the weight or length of the road 
     * @return weight the length of the road
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * setter method for weight
     * @param i weight that is going to replace current weight
     */
    public void setWeight(int i) {
    	weight = i;
    }
    /**
     * setter method for destination
     * @param d town that is going to replace destination
     */
    public void setDestination(Town d) {
    	destination = d;
    }
    
    /**
     * setter method for source
     * @param s town that is going to replace source 
     */
    public void setSource(Town s) {
    	source = s;
    }
    
    /**
     * setter method for roadName.
     * @param n the name that is going to replace roadName
     */
    public void setName (String n) {
    	roadName = n;
    }

    /**
     * returns the name of the road
     * @return roadName the name of the road
     */
    @Override
    public String toString() {
        return roadName;
    }

    /**
     * compares both source and destination towns this object
     * and of the parameter object, to see if both towns are the same 
     * in both roads. if both x and y are 0, meaning both towns are the same,
     * then the names of both roads are compared 
     * @return an int comparing the name, the source, and destination town of the road 
     */
    @Override
    public int compareTo(Road o) {
    	
    	int x = this.destination.compareTo(o.destination);
    	int y = this.source.compareTo(o.source);
    	
    	if(x != 0)
    		return x;
    	if(y != 0)
    		return y;
    	
        return this.roadName.compareTo(o.roadName);
    }

    /**
     * compares this object with the parameter object if they are the same.
     * returns true if the destination town and the source town is the same in both object.
     * @return true if the destination and source town is the same, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Road other = (Road) o;
        return (this.source.equals(other.source) && this.destination.equals(other.destination)) ||
               (this.source.equals(other.destination) && this.destination.equals(other.source));
    }

    /**
     * creates a hash code using the source town, destination town, and name of the road.
     * @return hash code using the source,destination and name of the road
     */
    @Override
    public int hashCode() {
        return source.hashCode() + destination.hashCode() + roadName.hashCode();
    }
}
