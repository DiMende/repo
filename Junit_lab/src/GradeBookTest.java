import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook t1 = new GradeBook(5);
	private GradeBook t2 = new GradeBook(5);
	@BeforeEach
	void setUp() throws Exception {
		t1 = new GradeBook(5);
		t2 = new GradeBook(5);
		t2.addScore(3.12);
		t2.addScore(1.29);
		t2.addScore(3.634);
		t1.addScore(9.132);
		t1.addScore(7.325);
	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = null;
		t2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(t1.toString().equals("9.132 7.325 "));
		assertTrue(t2.toString().equals("3.12 1.29 3.634 "));
		
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2,t1.getScoreSize());
		assertEquals(3,t2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(8.044,t2.sum());
		assertEquals(16.457,t1.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(1.29,t2.minimum());
		assertEquals(7.325,t1.minimum());

	}

	@Test
	void testFinalScore() {
		assertEquals(6.754,t2.finalScore(),.001);
		assertEquals(9.132,t1.finalScore(),.001);
	}

//	@Test
//	void testToString() {
//		fail("Not yet implemented");
//	}

}
