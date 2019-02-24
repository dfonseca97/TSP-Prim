package tsp;
import java.io.FileNotFoundException;


/**
 * 
 * @author Diego Antonio Fonseca Guzmán
 */
public class Main {

    /**
     * Sets up graph and calls the Prim's Algorithm method. 
     * Checks correct application usage.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ArrayIndexOutOfBoundsException{

        if(args.length == 0){

            System.out.println("Proper Usage is: java program filename");
            Runtime.getRuntime().exit(0);
        }

        try{

           final Reader reader = new Reader(args[0]);
           final Graph graph =  reader.readGraph();
           final Prim prim = new Prim(graph);
           prim.prim();

        } catch(FileNotFoundException fnf){
           
            System.out.println("The specified file does not exist.");
            
        } catch (ArrayIndexOutOfBoundsException oob) {
            
            System.out.println("The specified graph size has been exeeded.");
        }
        
        
    }
}