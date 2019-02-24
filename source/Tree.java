package tsp;
import java.util.List;
import java.util.ArrayList;

/**
 * Class used for creating a tree data structure, 
 * needed to perform Prim's Algorithm.
 * Makes use of tree nodes.
 * @author Diego Antonio Fonseca Guzmán
 */
public class Tree {

    /**
     * A list of the node's children.
     */
    private final List<TreeNode> nodes;

    /**
     * Creates a Tree data structure. It is represented as a list of tree nodes.
     */
    public Tree() {

        nodes = new ArrayList<>();
    }

    /**
     * Adds a new node to the tree.
     */
    public void addNode(final TreeNode node) {

        this.nodes.add(node);
    }

    /**
     * Get a list of the nodes in a tree.
     * @return ArrayList<TreeNode> All of the nodes in one tree.
     */
    public List<TreeNode> getNodes() {

        return nodes;
    }

    /**
     * Prints a Tree in pre-order. This way of evaluating the tree will produce 
     * a good aproximation of the shortest circuit.
     * @param root Tree's root
     */
    public void printTree(final TreeNode root) {

        System.out.print(root.getData() + " -> ");

        for (int i = 0; i < root.getChildren().size(); ++i) {

            printTree(root.getChildren().get(i));
            System.out.print(root.getData() + " -> ");
        }

    }

}