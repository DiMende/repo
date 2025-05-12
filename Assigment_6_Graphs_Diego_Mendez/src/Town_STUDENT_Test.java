import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
	
	private Town t1,t2,t3,t1_copy,t1_sameName;

	
	@BeforeEach
	void setUp() throws Exception {
		t1 = new Town("t1");
		t2 = new Town("t2");
		t3 = new Town("t3");
		t1_copy = new Town(t1);
		t1_sameName = new Town("t1");

	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = null;
		t2 = null;
		t3 = null;
		t1_copy = null;
		t1_sameName = null;
	}

	@Test
    void testConstructorWithName() {
        assertEquals("t1", t1.getName());
    }

    @Test
    void testCopyConstructor() {
        assertEquals("t1", t1_copy.getName());
        assertNotSame(t1, t1_copy);
        assertEquals(t1, t1_copy);
    }


    @Test
    void testCompareTo() {
        assertTrue(t1.compareTo(t2) < 0);
        assertTrue(t2.compareTo(t1) > 0);
        assertEquals(0, t1.compareTo(t1_sameName));
        assertTrue(t1.compareTo(t3) < 0);
    }

    @Test
    void testGetName() {
        assertEquals("t1", t1.getName());
        assertEquals("t2", t2.getName());
        assertEquals("t3", t3.getName());
    }

    @Test
    void testSetName() {
        t1.setName("a");
        assertEquals("a", t1.getName());
    }

    @Test
    void testToString() {
        assertEquals("t1", t1.toString());
        assertEquals("t2", t2.toString());
    }

    @Test
    void testHashCode() {
        assertEquals(t1.hashCode(), t1_sameName.hashCode());
        assertNotEquals(t1.hashCode(), t2.hashCode());
        int t1HashCode = t1.hashCode();
        t1.setName("a"); 
        assertNotEquals(t1HashCode, t1.hashCode());
        t1.setName("t1"); 
        assertEquals(t1HashCode, t1.hashCode());
    }



    @Test
    void testEquals() {
        assertTrue(t1.equals(t1_sameName));
        assertTrue(t1_sameName.equals(t1));
        assertTrue(t1.equals(t1));
        assertFalse(t1.equals(t2));
        assertFalse(t2.equals(t3));
        assertTrue(t1.equals(t1_copy));
        assertTrue(t1_copy.equals(t1));

    }

}
