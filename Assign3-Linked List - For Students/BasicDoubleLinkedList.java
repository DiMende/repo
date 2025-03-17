import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author Diego Mendez
 * @param <T>
 * Three attributes: head that points to the first node of the list
 * tail that points to the last element of the list
 * size that keeps track of how many elements there are in the link list
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	
	
	protected Node head;
	protected Node tail;
	protected int size;
	
	/**
	 * Initializes head,tail to null and size to zero 
	 */
	public BasicDoubleLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	
	/**
	 * Adds to the element front of the list
	 * if there are no elements in the list, then head points to a new node and tail 
	 * else temp will create a new node with element passed in as the data, temp.next will point to head
	 * head.prev will point back to temp, and head will point to head.prev which is temp. size is incremented by one.
	 * @param element
	 */
	public void addToFront(T element) {
		if(size == 0) {
			head = new Node(element);
			tail = head;
		} else {
			Node temp = new Node(element);
			temp.next = head;
			head.prev = temp;
			head = head.prev;
		}
		
		size++;
	}
	
	/**
	 * Adds element to the end of the list.
	 * if there is nothing in the list, then a new node is created, which head and tail both point to.
	 * else a new node called temp is created and element is passed into the constructor. temp.prev points to tail, tail.next points to temp and tail points back to
	 * tail.next which is temp. size is incremented by one
	 * @param element
	 * @return void
	 */
	public void addToEnd(T element) {
		if(size == 0) {
			head = new Node(element);
			tail = head;
		} else { 
			Node temp = new Node(element);
			temp.prev = tail;
			tail.next = temp;
			tail = tail.next;
		}
		size++;

		
	
	}
	
	
	/**
	 * returns the first element of the list which is in head.data
	 * @return T data
	 */
	public T getFirst() {
		return head.data;
	}
	
	/**
	 * returns the last element of the list which is in tail.data
	 * @return T data
	 */
	public T getLast() {
		return tail.data;
	}
	/**
	 * returns the size of the array in int
	 * @return int size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * returns a DoubleLinkedListIterator object
	 * @return ListIterator which is a DoubleLinkedListIterator
	 */
	@Override
	public ListIterator<T> iterator() {
		
		return new DoubleLinkedListIterator();
		
	}
	
	/**
	 * removes and returns the data of head. 
	 * temp stores head.data, head points to the next node in the list
	 * temp which contains the data is returned
	 * @return T data of first element in list
	 */
	public T retrieveFirstElement() {
		
		T temp = head.data;
		head = head.next;
		
		return temp;
	}
	/**
	 * removes and returns data of tail.
	 * temp stores data of tail. tail points to the previous node in the list.
	 * temp is returned.
	 * 
	 * @return T data of last element
	 */
	public T retrieveLastElement() {
		T temp = tail.data;
		tail = tail.prev;
		
		return temp;
	}
	
	/**
	 * iterates through the list using a while loop and currNode to keep track of position. currNode is first pointing to the head of the list
	 * while currNode does not equal null and compare method does not return 0 when element and currNode.data is compared, 
	 * currNode points to the next node of the list.
	 * 
	 * If the list is traversed and currNode is null, that means there were no elements in the list that matched the element parameter, thus returns null.
	 * If the previous node from the current node equals null then currNode is at the front of the list, so head moves on to the next node of the list, size is decreased by one and 
	 * the node is returned.
	 * if the next node from the current node equals null, then the element is at the end of the list, so tail moves to the previous node, size is decreased by one, and the node
	 * that was just removed is returned.
	 * if both the previous node and the next node is not null, then that means that the element is in the middle of the list. 
	 * prevNode and nextNode store previous node and the next node from current respectively. prevNode.next points over to nextNode, and nextNode.prev points to prevNode effectively removing
	 * the node from the list. size is decreased by one and the removed node is returned.
	 * 
	 * 
	 * @param element
	 * @param comparator
	 * @return Node that was removed from list, null if nothing was removed
	 */
	protected Node remove(T element, Comparator<T> comparator) {
		
				
		Node currNode = head;
		while( currNode != null && comparator.compare(element, currNode.data) != 0) 
			currNode = currNode.next;
		
		
		if(currNode == null) {
			return null;
		}
		if(currNode.prev == null) {
			size--;
			head = head.next; 
			return currNode;
		}else if(currNode.next == null) {
			size--;
			tail = tail.prev;
			return currNode;
		}
		
		Node prevNode = currNode.prev;
		Node nextNode = currNode.next;
		
		
		prevNode.next = nextNode;
		nextNode.prev = prevNode;
		
		
		size--;
		
		return currNode;
	}
	
	/**
	 * creates an ArrayList named list to store the link list.
	 * currNode points to head of linkList.
	 * @return ArrayList of the link list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<T>();
		Node currNode = head;
		
		while( currNode != null ) {
			list.add(currNode.data);
			currNode = currNode.next;
		
		}
		return list;
	}
	
	
	
	
	
	/**
	 * Node is a protected inner class that has three attributes, prev which will point
	 * to a previous node, null if none, and next which will point to the next node, null if none.
	 * data will store the data of the node 
	 */
	protected class Node{
		protected Node next;
		protected Node prev;
		protected T data;
		/**
		 * creates a node by calling the second node constructor and passes in null as both 
		 * next and prev, and data to be stored in this.data
		 * @param data
		 */
		protected Node(T data){
			this(null,null,data);
		}
		/**
		 * creates a node that initializes prev, and next while storing the data
		 * into the class data
		 * @param prev
		 * @param next
		 * @param data
		 */
		protected Node(Node prev, Node next, T data){
			this.prev = prev;
			this.next = next;
			this.data = data;
		}
		
	


	}
	
	/**
	 * DoubleLinkedListIterator is a protected inner class that implements ListIterator and 
	 * has 4 attributes: cursor which will iterate through the list, jumps, which will keep count of how many jumps the cursor made, nextCalled which will track if
	 * next has been called last, and prevCalled which will keep track if previous has been called last.
	 * DoubleLinkedListIterator is list iterator for any object list.
	 * 
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T>{
		
		Node cursor;
		int jumps;
		boolean nextCalled;
		boolean prevCalled;
		
		/**
		 * sets attributes to default values.
		 */
		public DoubleLinkedListIterator() {
			cursor = head;
			jumps = 0;
			nextCalled = false;
			prevCalled = false;
		
		}
		
		
		/**
		 * checks if jumps is less the size of the list and if the cursor is null
		 * @return true if jumps is less than size and cursor is not null, false otherwise
		 */
		@Override
		public boolean hasNext() {
			return jumps < size && cursor != null;
		}
		
		/**
		 * next returns the data of the node that was jumped
		 * if jumps is equal to zero, then the list is at the start and cursor points to head
		 * T data holds data of jumped node, and nextCalled is set to true. If the list has a next element to jump,
		 * then if jumps is equal to  size - 1 and previous has been called, then the cursor will move first then
		 * the data will be returned. otherwise the data is stored first and then the cursor make a jump then the data is returned. jump is incremented by one, and 
		 *  prevCalled is set to false
		 * whenever the cursor moves forward.
		 * if hasNext is false, then NoSuchElementException is thrown.
		 * 
		 * @return T data of node that was jumped
		 * @throws NoSuchElementException when there is no next element 
		 */
		@Override
		public T next() throws NoSuchElementException{
			
			if(jumps == 0) 
				cursor = head;
			
			
			T data;
			
			nextCalled = true;

			
			
			if(hasNext()) {
					if(jumps == size-1 && prevCalled) {
						jumps++;
						prevCalled = false;
						cursor = cursor.next; 
						data = cursor.data;
						return data;
					} else {
						jumps++;
						prevCalled = false;
						data = cursor.data;
						cursor = cursor.next; 	
						return data;
					}
				
			} 
			
			
			
			
			throw new NoSuchElementException();
			
		}
		
		
		/**
		 * returns if jumps is greater than 0
		 * @return true if jumps is greater than 0, false otherwise
		 */
		@Override
		public boolean hasPrevious() {
			return jumps > 0;
		}
	
		/**
		 * previous returns the element that was jumped over. 
		 * if jumps is equal to size, then the iterator is at the end of the list and so cursor points to tail.
		 * prevCalled is set to true and data is declared as generic object. If hasPrevious is true, then if next has not been called 
		 * previously, and the iterator is not at the end of the list, then data is stored first, the cursor moves backwards and the data is returned of node 
		 * where the cursor was pointing before. if both conditions are met, then the cursor moves first, then the data is set to the node data of where to cursor moved. 
		 * Jumps is decreased by one and nextCalled is false whenever the cursor moves backwards. If hasPrevious is false, then NoSuchElementException is thrown
		 * 
		 * @return T data of what was jumped over
		 * @throws NoSuchElementException if there is no previous element
		 * 
		 */
		@Override
		public T previous() throws NoSuchElementException {
			
			if(jumps == size)
				  cursor = tail;
			
			prevCalled = true;
			
			T data;
			
			if(hasPrevious()) {
				if(!nextCalled || jumps == size) {
					jumps--;
					nextCalled = false;
					data = cursor.data;
					cursor = cursor.prev;
					return data;
				} else {
					nextCalled = false;
					jumps--;
					cursor = cursor.prev;
					data = cursor.data;
					return data;
				}
			} 
			
			
			throw new NoSuchElementException();
			
			
		}

		
		/**
		 * nextIndex is an unsupported operation for DoubleLinkedListIterator
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();

		}
		
		/**
		 * previousIndex is an unsupported operation for DoubleLinkedListIterator
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		/**
		 * remove is an unsupported operation for DoubleLinkedListIterator
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		/**
		 * set is an unsupported operation for DoubleLinkedListIterator
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void set(Object e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * add is an unsupported operation for DoubleLinkedListIterator
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void add(Object e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		
	}

	
	
	
	

}
