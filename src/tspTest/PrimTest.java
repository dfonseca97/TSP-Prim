package tspTest;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import tsp.Prim;
import tsp.Graph;
import tsp.Reader;
import tsp.Tree;

class PrimTest {
	
	@Test
	void testMakeTree() throws FileNotFoundException {
		
		Reader testReader = new Reader("primTest.txt");
		Graph graph = testReader.readGraph();
		Prim prim = new Prim(graph);
		int [] primRes = prim.prim();
		int [] primAnswer = {-1,0,1,4,5,2};
		Tree makeTreeRes = prim.makeTree(primRes);
		Tree treeAnswer = prim.makeTree(primAnswer);
		
		//Tree built correctly.
		assertEquals(treeAnswer.getNodes().get(0).getData(), makeTreeRes.getNodes().get(0).getData());
		assertEquals(treeAnswer.getNodes().get(1).getData(), makeTreeRes.getNodes().get(1).getData());
		assertEquals(treeAnswer.getNodes().get(2).getData(), makeTreeRes.getNodes().get(2).getData());
		assertEquals(treeAnswer.getNodes().get(3).getData(), makeTreeRes.getNodes().get(3).getData());
		assertEquals(treeAnswer.getNodes().get(4).getData(), makeTreeRes.getNodes().get(4).getData());
		assertEquals(treeAnswer.getNodes().get(5).getData(), makeTreeRes.getNodes().get(5).getData());

	}

}
