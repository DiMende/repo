/**
 * @author Diego Mendez
 * Town implements comparable and is used as a vertex in a graph town.
 * Has one attribute:
 * -townName name of the town
 * 
 */
public class Town implements Comparable<Town> {

    private String townName;
    private Town backPathVertex;

    /**
     * creates a town object with townName parameter
     * @param townName name of the town
     */
    public Town(String townName) {
        this.townName = townName;
    }

    /**
     * deep copy constructor
     * @param templateTown town to be deep copied
     */
    public Town(Town templateTown) {	
    	this.townName = templateTown.townName;
    }
    

    /**
     * compares both townNames of this and the parameter object.
     * @return int value of this townName compared to parameter town name
     */
    @Override
    public int compareTo(Town o) {
        return this.townName.compareTo(o.townName);
    }

    /**
     * returns the name of the town
     * @return townName the name of the town
     */
    public String getName() {
        return townName;
    }

   
    /**
     * sets townName to a new name
     * @param name name that replaces the current town name
     */
    public void setName(String name) {
        this.townName = name;
    }

    /**
     * returns the town name of the town by toString
     * @return townName the town name of the town
     */
    @Override
    public String toString() {
        return townName;
    }

    /**
     * creates and returns a hash code using the towns name
     * @return hash code of the object by using townName
     */
    @Override
    public int hashCode() {
        return townName.hashCode();
    }
    
    /**
     * Sets the back path vertex of the object vertex.
     * @param t town that is in the back path of the vertex.
     */
    public void setBackPath(Town t) {
    	backPathVertex = t;
    }

    /**
     * compares both town names of the current object and the parameter object to see if 
     * both objects are equal.
     * @return true if the town name equals the parameter towns name, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Town other = (Town) o;
        return this.townName.equals(other.townName);
    }
}
