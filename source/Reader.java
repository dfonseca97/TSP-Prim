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

    /**
     * The file with the graph information
     */
    private final File file;

    /**
     * The scanner that will read the file information
     */
    private final Scanner scan;

    /**
     * Creates a new reader to extract graph information from a file.
     */
    Reader(String fileDir) throws FileNotFoundException{

        this.file = new File(fileDir);
        scan = new Scanner(this.file);
    }

    /**
     * This method reads a document 
     * with graph information and loads it into the program.
     * The first line of the document should be 
     * the amount of vertices, the next lines 
     * will contain each source, destination, weight of the arcs 
     * in that order. The method then creates 
     * the graph and closes the scanner, releasing the resources.
     * 
     * @return Graph This is the text represented as a graph.
     */
    public Graph readGraph() {

        final int size = scan.nextInt();
        Graph graph = new AMGraph(size);

        while(scan.hasNext()){

            int source = scan.nextInt();
            int destination = scan.nextInt();
            int weight = scan.nextInt();

            graph.addArc(source, destination, weight);
            
        }

        scan.close();
        return graph;
    }
}