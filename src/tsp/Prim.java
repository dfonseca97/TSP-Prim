package tsp;
import java.util.HashSet;
import java.util.Set;

/**
 * A class containing the needed algorithms to get an approximate 
 * solution for the TSP.
 * @author Diego Antonio Fonseca Guzmán
 */
public class Prim {

    /**
     * Graph to be analyzed.
     */
    private final Graph graph;

    /**
     * Creates an instance of the class. Requires a graph to
     * apply the algorithm to. 
     */
    public Prim(final Graph graph){

        this.graph = graph;
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
     * @param graph Graph to apply Prim's algorithm on
     * @return Integer Array representing the Minimum Spanning Tree
     */
    public int[] prim() {

        int[] res = new int[graph.size];
        boolean[] visited = new boolean[graph.size];
        int[] weights = new int[graph.size];
        int sum = 0;

        for (int i = 0; i < graph.size; ++i) {

            weights[i] = Integer.MAX_VALUE;
        }

        weights[0] = 0;
        res[0] = -1;

        for (int i = 0; i < graph.size; ++i) {

            int next = minVal(visited, weights);
            visited[next] = true;

            for (int j = 0; j < graph.size; ++j) {

                if (graph.getWeight(next, j) > 0 && !visited[j] && graph.getWeight(next, j) < weights[j]) {

                    res[j] = next;
                    weights[j] = graph.getWeight(next, j);

                }
            }

        }

        printMST(res);
        final Tree tree = makeTree(res);
        System.out.print("Shortest Circuit:");
        tree.printTree(tree.getNodes().get(0));
        System.out.println("End");

        for (int i = 1; i < graph.size; ++i) {

            sum += graph.getWeight(res[i], i);
        }

        System.out.println("Total distance: " + sum * 2);
     
        return res;
    }

    /**
     * Constructs the Minimum Spanning Tree used to 
     * evaluate the shortest circuit in the graph.
     * @param nodes Array containing the Minimum Spanning Tree
     * @return Minimum Spanning Tree
     */
    public Tree makeTree(int[] nodes) {

        final Tree res = new Tree();
        final Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nodes.length; ++i) {

            set.add(nodes[i]);

        }


        for (int i = 0; i < graph.size; ++i) {

            TreeNode node = new TreeNode(i);
            res.addNode(node);

        }

        for (int i = 1; i < graph.size; ++i) {

            res.getNodes().get(nodes[i]).addChild(res.getNodes().get(i));

        }

        return res;
    }

    /**
     * Prints the connection between nodes in 
     * the Minimum Spanning Tree and their respective weights.
     * @param graph Graph to be evaluated
     * @param res Integer Array representing the Minimum Spanning Tree
     */
    public void printMST(int[] res) {

        System.out.println("Minimum Spanning Tree: ");
        
        for (int i = 1; i < graph.size; ++i) {

            System.out.println(res[i] + ", " + i + " Weight: " + graph.getWeight(res[i], i));
            
        }
    }
}
