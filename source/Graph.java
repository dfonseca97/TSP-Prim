package tsp;
import java.util.ArrayList;

/**
 * Base class used for representing a graph.
 * 
 * @author Diego Antonio Fonseca Guzmán
 */
public abstract class Graph {
    
   protected int size;
   
   public  Graph(int vertices)  {
       
       size = vertices;
       
   }
   
   public  abstract void addArc(int source, int destination, int weight);
   public abstract ArrayList<Integer> getSuccessors(int vertex);
   public abstract int getWeight(int source, int destination);
   
   public  int size() {
       
       return size;
       
   }
}