package tsp;
import java.util.ArrayList;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * Graph implementation using an adjacency matrix. The matrix represents a connection between two nodes,
 * the row represents the source and the column represents the destination, the value on that spot is the weight.
 * if there is no connection the value will be -1.
 * @author Diego Antonio Fonseca Guzmán
 */
public class AMGraph extends Graph {

    private int[][] vertices;

    public AMGraph(int size) {

        super(size);

        vertices = new int[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {

                vertices[i][j] = -1;
                
            }
        }
    }

    public int[][] getEdges() {
        return vertices;
    }

    public int getWeight(int source, int destination) {
        
        return vertices[source][destination];
        
    }

    public void addArc(int source, int destination, int weight){
        
        vertices[source][destination] = weight;


    }

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
