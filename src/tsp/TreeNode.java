package tsp;
import java.util.List;
import java.util.ArrayList;

/**
 * Class used for creating Tree nodes. 
 * Each nodes consists of an integer value
 * and a list of child nodes.
 * @author Diego Antonio Fonseca Guzmán
 */
public class TreeNode {
    
    /**
     * Information contained in the node
     */
    private final int data;

    /**
     * A list of a node's children.
     */
    private final List<TreeNode> children;
    
    /**
     * Creates a single node. 
     * It will have an integer value and a list of its children nodes.
     */
    public TreeNode(final int data){
        
        this.data = data;
        this.children = new ArrayList<>();
    }
    
    /**
     * Adds a child node to a specific node.
     */
    public void addChild(final TreeNode child){
        
        this.children.add(child);
    }
    
    /**
     * Get the value of a node.
     * @return int The information contained in a node.
     */
    public int getData(){
        
        return data;
    }
    
    /**
     * Get a list of a node's children
     * @return ArrayList<TreeNode> A list of a specific node's children.
     */
    public List<TreeNode> getChildren(){
        
        return children;
    }
}
