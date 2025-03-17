


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedList_GFA_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	

	@Before
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
	}

	@After
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
		}
		catch (UnsupportedOperationException e)
		{
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}


}
