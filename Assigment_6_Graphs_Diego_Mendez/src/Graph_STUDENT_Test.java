import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> studentGraph;
	private Town[] studentTowns;
	
	
	@BeforeEach
	void setUp() throws Exception {
		studentGraph = new Graph();
		studentTowns = new Town[10];
		
		for(int i = 0; i < 10;i++) {
			studentTowns[i] = new Town("Town_"+i);
			studentGraph.addVertex(studentTowns[i]);
		}
		
		studentGraph.addEdge(studentTowns[1], studentTowns[2], 2, "Road_1");
		studentGraph.addEdge(studentTowns[1], studentTowns[3], 4, "Road_2");
		studentGraph.addEdge(studentTowns[1], studentTowns[5], 6, "Road_3");
		studentGraph.addEdge(studentTowns[3], studentTowns[7], 1, "Road_4");
		studentGraph.addEdge(studentTowns[3], studentTowns[8], 2, "Road_5");
		studentGraph.addEdge(studentTowns[4], studentTowns[8], 3, "Road_6");
		studentGraph.addEdge(studentTowns[6], studentTowns[9], 3, "Road_7");
		studentGraph.addEdge(studentTowns[9], studentTowns[10], 4, "Road_8");
		studentGraph.addEdge(studentTowns[8], studentTowns[10], 2, "Road_9");
		studentGraph.addEdge(studentTowns[5], studentTowns[10], 5, "Road_10");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		studentGraph = null;
	}

	@Test
	void testGetEdge() {
		assertEquals(new Road(studentTowns[2], studentTowns[10],6, "Road_12"), studentGraph.getEdge(studentTowns[2], studentTowns[10]));
		assertEquals(new Road(studentTowns[3], studentTowns[7],1, "Road_4"), studentGraph.getEdge(studentTowns[3], studentTowns[7]));
	}

}
