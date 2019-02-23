package tsp;
import java.util.ArrayList;

/**
 * Class used for creating a Tree data structure, needed to perform Prim's Algorithm.
 * Makes use of Tree nodes.
 * @author Diego Antonio Fonseca Guzmán
 */
public class Tree {

    private ArrayList<TreeNode> nodes;

    public Tree() {

        nodes = new ArrayList<>();
    }

    public void addNode(TreeNode node) {

        this.nodes.add(node);
    }

    public ArrayList<TreeNode> getNodes() {

        return nodes;
    }

    /**
     * Prints a Tree in pre-order. This way of evaluating the tree will produce 
     * a good aproximation of the shortest circuit.
     * @param root Tree's root
     */
    public void printTree(TreeNode root) {

        System.out.print(root.getData() + " -> ");

        for (int i = 0; i < root.getChildren().size(); ++i) {

            printTree(root.getChildren().get(i));
            System.out.print(root.getData() + " -> ");
        }

    }

}
