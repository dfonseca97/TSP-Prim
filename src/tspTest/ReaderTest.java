package tspTest;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import tsp.Graph;
import tsp.AMGraph;
import tsp.Reader;


import org.junit.jupiter.api.Test;

class ReaderTest {

	@Test
	void testReadGraph() throws FileNotFoundException {
		
		Reader testReader = new Reader("readerTest.txt");
		Graph readerRes = testReader.readGraph();
		Graph readerAnswer = new AMGraph(8);
		
		readerAnswer.addArc(0, 1, 1);
		readerAnswer.addArc(0, 4, 3);
		readerAnswer.addArc(0, 2, 2);
		readerAnswer.addArc(1, 3, 2);
		readerAnswer.addArc(1, 6, 3);
		readerAnswer.addArc(2, 5, 4);
		readerAnswer.addArc(2, 4, 1);
		readerAnswer.addArc(3, 4, 2);
		readerAnswer.addArc(3, 6, 3);
		readerAnswer.addArc(4, 1, 1);
		readerAnswer.addArc(4, 7, 5);
		readerAnswer.addArc(4, 3, 2);
		readerAnswer.addArc(5, 7, 4);
		readerAnswer.addArc(5, 0, 5);
		readerAnswer.addArc(6, 7, 1);
		readerAnswer.addArc(7, 6, 4);
		readerAnswer.addArc(7, 5, 2);
		
		//Correct weight assignment
		assertEquals(readerAnswer.getWeight(0, 1), readerRes.getWeight(0, 1));
		assertEquals(readerAnswer.getWeight(0, 4), readerRes.getWeight(0, 4));
		assertEquals(readerAnswer.getWeight(0, 2), readerRes.getWeight(0, 2));
		assertEquals(readerAnswer.getWeight(1, 3), readerRes.getWeight(1, 3));
		assertEquals(readerAnswer.getWeight(1, 6), readerRes.getWeight(1, 6));
		assertEquals(readerAnswer.getWeight(2, 5), readerRes.getWeight(2, 5));
		assertEquals(readerAnswer.getWeight(2, 4), readerRes.getWeight(2, 4));
		assertEquals(readerAnswer.getWeight(3, 4), readerRes.getWeight(3, 4));
		assertEquals(readerAnswer.getWeight(3, 6), readerRes.getWeight(3, 6));
		assertEquals(readerAnswer.getWeight(4, 1), readerRes.getWeight(4, 1));
		assertEquals(readerAnswer.getWeight(4, 7), readerRes.getWeight(4, 7));
		assertEquals(readerAnswer.getWeight(4, 3), readerRes.getWeight(4, 3));
		assertEquals(readerAnswer.getWeight(5, 7), readerRes.getWeight(5, 7));
		assertEquals(readerAnswer.getWeight(5, 0), readerRes.getWeight(5, 0));
		assertEquals(readerAnswer.getWeight(6, 7), readerRes.getWeight(6, 7));
		assertEquals(readerAnswer.getWeight(7, 6), readerRes.getWeight(7, 6));
		assertEquals(readerAnswer.getWeight(7, 5), readerRes.getWeight(7, 5));
		
		//Correct successors list creation
		assertTrue(readerAnswer.getSuccessors(0).equals(readerRes.getSuccessors(0)));
		assertTrue(readerAnswer.getSuccessors(1).equals(readerRes.getSuccessors(1)));
		assertTrue(readerAnswer.getSuccessors(2).equals(readerRes.getSuccessors(2)));
		assertTrue(readerAnswer.getSuccessors(3).equals(readerRes.getSuccessors(3)));
		assertTrue(readerAnswer.getSuccessors(4).equals(readerRes.getSuccessors(4)));
		assertTrue(readerAnswer.getSuccessors(5).equals(readerRes.getSuccessors(5)));
		assertTrue(readerAnswer.getSuccessors(6).equals(readerRes.getSuccessors(6)));
		assertTrue(readerAnswer.getSuccessors(7).equals(readerRes.getSuccessors(7)));

	}

}
