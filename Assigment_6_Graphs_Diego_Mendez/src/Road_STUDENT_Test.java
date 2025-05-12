import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {

	private Town t1, t2, t3;
    private Road r1, r2, r3;

    @BeforeEach
    void setUp() {
        t1 = new Town("t1");
        t2 = new Town("t2");
        t3 = new Town("t3");

        r1 = new Road(t1, t2, 4, "r1");
        r2 = new Road(t2, t3, 9, "r2");
        r3 = new Road(t1, t3, 3, "r3");
    }
    
    @AfterEach
    void tearDown() {
    	t1 = null; 
    	t2 = null;
    	t3 = null;
    	r1 = null;
    	r2 = null;
    	r3 = null;
    }

    @Test
    void testConstructorWithWeight() {
        assertEquals(t1, r1.getSource());
        assertEquals(t2, r1.getDestination());
        assertEquals(4, r1.getWeight());
        assertEquals("r1", r1.getName());
    }


    @Test
    void testGetName() {
        assertEquals("r1", r1.getName());
        assertEquals("r2", r2.getName());
    }

    @Test
    void testContains() {
        assertTrue(r1.contains(t1));
        assertTrue(r1.contains(t2));
        assertFalse(r1.contains(t3));
        assertFalse(r1.contains(new Town("t")));
    }

    @Test
    void testGetDestination() {
        assertEquals(t2, r1.getDestination());
        assertEquals(t3, r2.getDestination());
    }

    @Test
    void testGetSource() {
        assertEquals(t1, r1.getSource());
        assertEquals(t2, r2.getSource());
    }

    @Test
    void testGetWeight() {
        assertEquals(4, r1.getWeight());
        assertEquals(3,r3.getWeight());
    }
    
    @Test
    void testSetWeight() {
        r1.setWeight(15);
        assertEquals(15, r1.getWeight());
    }

    @Test
    void testSetDestination() {
        r1.setDestination(t3);
        assertEquals(t3, r1.getDestination());
    }

    @Test
    void testSetSource() {
        r1.setSource(t3);
        assertEquals(t3, r1.getSource());
    }
    
    @Test
    void testSetName() {
        r1.setName("NewRoadName");
        assertEquals("NewRoadName", r1.getName());
    }

    @Test
    void testToString() {
        assertEquals("r1", r1.toString());
    }

    @Test
    void testCompareTo() {
                
        assertTrue(r1.compareTo(r2) < 0); 
        assertTrue(r2.compareTo(r1) > 0);
        assertTrue(r3.compareTo(r2) > 0);


     
    }

    @Test
    void testEquals() {
   
    	Road r4 = new Road(t1,t2,"r4");
    	
        assertFalse(r1.equals(r2));
        assertTrue(r1.equals(r4));
        
        
    }

    @Test
    void testHashCode() {
        Road r1_copy = new Road(t1, t2, 4, "r1");
        Road r4 = new Road(t1, t2, 4, "r4");

        assertEquals(r1.hashCode(), r1_copy.hashCode());
        
        assertNotEquals(r1.hashCode(), r2.hashCode());
        assertNotEquals(r1.hashCode(), r4.hashCode());
        
        int r1HashCode = r1.hashCode();
        r1.setName("r0");
        assertNotEquals(r1HashCode, r1.hashCode());
        r1.setName("r1"); 
        assertEquals(r1HashCode, r1.hashCode());
    }

}
