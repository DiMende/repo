import java.util.*;



/**
 * @author Diego Mendez
 * @param <T>
 * 
 * SortedDoubleLinkedList extends BasicDoubleLinkedList
 * it is the sorted version of a DoubleLinkedList
 * Has Comparator attribute compareableObject to compare objects 
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	
	Comparator<T> compareableObject;
	
	
	/**
	 * Takes in a Comparator object to help sort the link list
	 * Calls the super class constructor to initialize each of the 3 attributes in 
	 * BasicDoubleLinkedList
	 *
	 * @param compareableObject
	 */
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {
		super();
		this.compareableObject = compareableObject;
	}
	
	
	/**
	 * if the size is equal to 0, then head points to a new node and tail 
	 * points to head, else the list is traverse to find where the data can be put.
	 * Using currNode to traverse the list, if currNode is null or when compare method returns a number greater than or 
	 * equal to zero when currNode.data and the parameter data is passed in as arguments, the while loop will break. 
	 * newNode will create a new node with the parameter data. If  currNode is null, then the while loop
	 * traversed the entire list without finding any value greater than 0 and thus the data is the largest, so
	 * it will be placed at the end of the list and tail will point to the newNode. Else if currNode.prev is equal to null then currNode is 
	 * at the front of the list and head.prev will point to the newNode, newNode.next points to head, and head will point to newNode.
	 * if currNode is in the middle of the list, then prevNode will point to the previous node of currNode, newNode.prev will point to prevNode,
	 * newNode.next to the currNode, prevNode.next will point to newNode and same with currNode.prev so that the node is placed behind the current node and in front of the  
	 * previous node
	 * 
	 * 
	 * 
	 * 
	 * @param element of
	 */
	public void add(T element) {
	
		
		if(size == 0) {
			Node temp = new Node(element);
			head = temp;
			tail = head;
		} else {

		
			Node currNode = head;
			
			while( currNode != null && compareableObject.compare( currNode.data,element) < 0) {
				currNode = currNode.next;
			}
			
			
			
			Node newNode = new Node(element);
			
			if(currNode == null) {
				tail.next = newNode;
				newNode.prev = tail;
				tail = newNode;
			} else {
			
				if(currNode.prev == null) {
					head.prev = newNode;
					newNode.next = head;
					head = newNode;
				}else {
				
					Node prevNode = currNode.prev;
					
					newNode.prev = prevNode;
					newNode.next = currNode;
					prevNode.next = newNode;
					currNode.prev = newNode;
				}
			}	
			
			
							
			
		}
		
		size++;
		
		
		
	}
	
	
	/**
	 * calls the remove of the super class which is the remove of BasicDoubleLinkedList
	 * @param data, comparator
	 */
	public Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
	
	/**
	 * calls the iterator method of the super class
	 */
	@Override 
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * because addToEnd is not a supported method, the method throws the UnsupportedOperationException
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void addToEnd(T e) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * because addToFront is not a supported method, the method throws the UnsupportedOperationException
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void addToFront(T e) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
