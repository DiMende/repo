
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BasicDoubleLinkedListTest.Car;
import BasicDoubleLinkedListTest.DoubleComparator;

public class BasicDoubleLinkedList_GFA_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;



	@Before
	public void setUp() throws Exception {
		
		

		
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
	

	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
	
	}
	
	
	@Test
	public void traversingList() {
		//List: Whats up, Bye, Hello, Howdy
		
		linkedString.addToFront("Whats up");
		linkedString.addToEnd("Howdy");
		ListIterator<String> iteratorString = linkedString.iterator();
		assertEquals(true, iteratorString.hasNext());
		assertEquals("Whats up",iteratorString.next());
		assertEquals(true, iteratorString.hasPrevious());
		assertEquals("Whats up",iteratorString.previous());
		assertEquals("Whats up",iteratorString.next());
		assertEquals("Bye",iteratorString.next());
		assertEquals("Hello",iteratorString.next());
		assertEquals("Hello",iteratorString.previous());
		assertEquals("Hello",iteratorString.next());

	
	}
	
	@Test
	public void testRemove() {
		// remove the first
		linkedDouble.remove(2.2,comparatorD);
		linkedDouble.remove(2.2,comparatorD);

		assertEquals(null, linkedDouble.remove(2.2,comparatorD));
		
		
	}

	@Test	
	public void testGetSize() {
		assertEquals(2,linkedString.getSize());
	}	
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
}


