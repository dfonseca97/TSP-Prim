package tsp;
import java.io.File; 
import java.util.Scanner; 
import java.io.FileNotFoundException;

/**
 * Class in charge of reading a file containing graph information.
 * 
 * @author Diego Antonio Fonseca Guzmán
 */
class Reader{

    private File f;
    private Scanner scan;

    Reader(String fileDir) throws FileNotFoundException{

        this.f = new File(fileDir);
        scan = new Scanner(this.f);
    }

    /**
     * This method reads a document with graph information and loads it into the program.
     * The first line of the document should be the amount of vertices, the next lines 
     * will contain each source, destination, weight of the arcs in that order. The method
     * then creates the graph and closes the scanner, releasing the resources.
     * 
     * @return Graph This is the text represented as a graph.
     */
    public Graph readGraph() {

        int size = scan.nextInt();
        Graph g = new AMGraph(size);

        while(scan.hasNext()){

            int source = scan.nextInt();
            int destination = scan.nextInt();
            int weight = scan.nextInt();

            g.addArc(source, destination, weight);
            
        }

        scan.close();
        return g;
    }
}