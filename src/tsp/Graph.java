package tsp;
import java.util.Set;

/**
 * Base class used for representing a graph.
 * 
 * @author Diego Antonio Fonseca Guzmán
 */
public abstract class Graph {

    /**
     * Number of vertices in a graph
     */
    protected int size;
   
    /**
     * Creates a graph with a specific number of vertices
     */
    public  Graph(int vertices)  {
       
        size = vertices;
       
    }
    
    /**
     * Adds a connection from a vertex to another.
     * @param source Source vertex
     * @param destination Destination vertex
     * @param weight Cost to travel from source to destination
     */
    public abstract void addArc(int source, int destination, int weight);

    /**
     * Returns the successors of a vertex.
     * @param vertex The vertex to be evaluated
     */
    public abstract Set<Integer> getSuccessors(int vertex);

    /**
     * Returns the cost to travel from one vertex to another.
     * @param source Source vertex
     * @param destination the destination vertex
     */
    public abstract int getWeight(int source, int destination);
    
    /**
     * Returns the number of vertices in a graph.
     * @return size int Number of vertices
     */
    public int size() {
       
        return size;
       
    }
}