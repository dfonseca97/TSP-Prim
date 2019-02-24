package tsp;
import java.util.ArrayList;

/**
 * Graph implementation using an adjacency matrix. The matrix represents a connection between two nodes,
 * the row represents the source and the column represents the destination, the value on that spot is the weight.
 * if there is no connection the value will be -1.
 * @author Diego Antonio Fonseca Guzmán
 */
public class AMGraph extends Graph {

    private int[][] vertices;

    /**
     * Creates an Adjacency Matrix representation of a Graph, the size indicates the number of vertices.
     */
    public AMGraph(int size) {

        super(size);

        vertices = new int[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                vertices[i][j] = -1;
                
            }
        }
    }

    /**
     *  Get the Adjacency Matrix of the Graph.
     * @return int[][] Adjacency Matrix representation of the Graph.
     */
    public int[][] getEdges() {

        return vertices;

    }

    /**
     * Get the weight from one vertex to another.
     * @return int Returns the cost of going from one vertex to another, if there is no connection returns -1.
     */
    public int getWeight(int source, int destination) {
        
        return vertices[source][destination];
        
    }

    /**
     * Adds an arc to the Adjacency Matrix.
     */
    public void addArc(int source, int destination, int weight) {
        
        vertices[source][destination] = weight;
    }

    /**
     * Get all of a vertex's successors.
     * @return ArrayList<Integer> A list containing all of a vertex's successors.
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        
        ArrayList<Integer> successors = new ArrayList<Integer>();
        
        for (int j = 0; j < size; j++) {
            
            if (vertices[vertex][j] != -1) {
                
                successors.add(j);
                
            }
        }
        
        return successors;

    }
}
