package tsp;
import java.util.HashSet;
import java.util.Set;
import java.io.FileNotFoundException;


/**
 * A class containing the needed algorithms to solve the TSP.
 * @author Diego Antonio Fonseca Guzmán
 */
public class Prim {

    /**
     * Sets up graph and calls the Prim's Algorithm method.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{

        try{

           Reader r = new Reader(args[0]);
           Graph g =  r.readGraph();
           prim(g);

        } catch(FileNotFoundException fnf){
           
            System.out.println("The specified file does not exist.");
            
        } catch (ArrayIndexOutOfBoundsException oob) {
           
            System.out.println("The specified graph size has been exeeded."); 
         }
    }

    /**
     * Chooses the shortest path to the next node if it has not been visited yet.
     * @param visited Boolean Array representing the visited nodes
     * @param weights Integer Array representing the weights of the graph's edges
     * @return Vertex with the minimum weight from the set of Vertices
     */
    public static int minVal(boolean[] visited, int[] weights) {

        int minWeight = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int i = 0; i < weights.length; ++i) {

            if (!visited[i] && (weights[i] < minWeight)) {

                minWeight = weights[i];
                minVertex = i;
            }

        }

        return minVertex;

    }

    /**
     * Applies Prim's algorithm to a graph. This will result in the Minimum
     * Spanning Tree of the graph. A Minimum Spanning Tree is a representation
     * of the graph including only the minimum weight arcs.
     * @param g Graph to apply Prim's algorithm on
     * @return Integer Array representing the Minimum Spanning Tree
     */
    public static int[] prim(Graph g) {

        int[] res = new int[g.size];
        boolean[] visited = new boolean[g.size];
        int[] weights = new int[g.size];
        int sum = 0;

        for (int i = 0; i < g.size; ++i) {

            weights[i] = Integer.MAX_VALUE;
        }

        weights[0] = 0;
        res[0] = -1;

        for (int i = 0; i < g.size; ++i) {

            int next = minVal(visited, weights);
            visited[next] = true;

            for (int j = 0; j < g.size; ++j) {

                if (g.getWeight(next, j) > 0 && !visited[j] && g.getWeight(next, j) < weights[j]) {

                    res[j] = next;
                    weights[j] = g.getWeight(next, j);

                }
            }

        }

        //  printMST(g, res);
        Tree tree = makeTree(g, res);
        System.out.print("Shortest Circuit:");
        tree.printTree(tree.getNodes().get(0));
        System.out.println();

        for (int i = 1; i < g.size; ++i) {

            sum += g.getWeight(res[i], i);
        }

        System.out.println("Total distance: " + sum * 2);
        return res;
    }

    /**
     * Constructs the Tree used to evaluate the shortest circuit in the graph.
     * @param g Graph to be evaluated
     * @param nodes Array containing the Minimum Spanning Tree
     * @return Minimum Spanning Tree
     */
    public static Tree makeTree(Graph g, int[] nodes) {

        Tree res = new Tree();
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nodes.length; ++i) {

            set.add(nodes[i]);

        }

        Object[] SetArr = set.toArray();

        for (int i = 0; i < g.size; ++i) {

            TreeNode node = new TreeNode(i);
            res.addNode(node);

        }

        for (int i = 1; i < g.size; ++i) {

            res.getNodes().get(nodes[i]).addChild(res.getNodes().get(i));

        }

        return res;
    }

    /**
     * Prints the connection between nodes in the Minimum Spanning Tree and their respective weights.
     * @param g Graph to be evaluated
     * @param res Integer Array representing the Minimum Spanning Tree
     */
    public static void printMST(Graph g, int[] res) {

        System.out.println("MST: ");
        
        for (int i = 1; i < g.size; ++i) {

            System.out.println(res[i] + ", " + i + " Weight: " + g.getWeight(res[i], i));
            
        }
    }
}
