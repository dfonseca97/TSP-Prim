package tsp;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Graph implementation using an adjacency matrix. 
 * The matrix represents a connection between two nodes,
 * the row represents the source and the column represents the destination, 
 * the value on that spot is the weight.
 * if there is no connection the value will be -1.
 * @author Diego Antonio Fonseca Guzmán
 */
public class AMGraph extends Graph {

    /**
     * The Adjacency Matrix of the graph
     */
    private int[][] vertices;

    /**
     * Creates an Adjacency Matrix representation of a Graph, 
     * the size indicates the number of vertices.
     */
    public AMGraph(final int size) {

        super(size);

        vertices = new int[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                vertices[i][j] = -1;
                
            }
        }
    }

    /**
     * Get the Adjacency Matrix of the Graph.
     * @return int[][] Adjacency Matrix representation of the Graph.
     */
    public int[][] getVertices() {

        return vertices.clone();

    }

    /**
     * Get the weight from one vertex to another.
     * @return int Returns the cost of going from one vertex to another, 
     * if there is no connection returns -1.
     */
    public int getWeight(final int source, final int destination) {
        
        return vertices[source][destination];
        
    }

    /**
     * Adds an arc to the Adjacency Matrix.
     */
    public void addArc(final int source, final int destination, final int weight) {
        
        vertices[source][destination] = weight;
    }

    /**
     * Get all of a vertex's successors.
     * @return ArrayList<Integer> A list containing all of a vertex's successors.
     */
    public Set<Integer> getSuccessors(final int vertex) {
        
        final List<Integer> successors = new ArrayList<>();
        
        for (int j = 0; j < size; j++) {
            
            if (vertices[vertex][j] != -1) {
                
                successors.add(j);
                
            }
        }
        
        return new HashSet<Integer>(successors);

    }
}
