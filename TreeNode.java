package tsp;
import java.util.ArrayList;

/**
 * Class used for creating Tree nodes. Each nodes consists of an integer value
 * and a list of child nodes.
 * @author Diego Antonio Fonseca Guzmán
 */
public class TreeNode {
    
    private int data;
    private ArrayList<TreeNode> children;
    
    public TreeNode(int data){
        
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }
    
    public void addChild(TreeNode child){
        
        this.children.add(child);
    }
    
    public int getData(){
        
        return data;
    }
    
    public ArrayList<TreeNode> getChildren(){
        
        return children;
    }
}
