import java.io.IOException;
import java.util.ArrayList;
/**
 * CourseDBStructure is the class that creates a hash table by creating an array of Nodes to store a 
 * "bucket format" hash table. Each node will contain a CourseDBElement which represents a course with 5 attributes.
 * CourseDBStructor has two attributes: 
 * - hashTable: an array of nodes (Nodes)
 * - test: holds the test string of the CourseDBStructor(String) 
 * CourseDBStructure implements the CourseDBStructureInterface.
 * @author Diego Mendez
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	
	private Node[] hashTable;
	private String test;
	/**
	 * Constructors a CourseDBStructure object with the specified length n of the hashTable.
	 * Using the specified length n, the constructor calculates the 4k+3 prime by first dividing n
	 * by the lambda value of a bucket hash table, then calculating the k value. A while loop is used to find the 4k+3 that is a prime and that
	 * is greater than the hash table n size. Once the 4k+3 prime is found that is greater than the initial n, then one last function is called, getNearestInt
	 * which takes 3 parameters to find the integer than is the nearest to the initial n value. Once that is found, the value is passed in as the table size.
	 * test is set to default value of null
	 * @param n length of the hashTable array 
	 */
	public CourseDBStructure(int n) {
		int i,j = i =(int)(n/1.5);
		
		int k = (j - 3)/4;
		while(!is4kp3(j) || j < n) {
			k++;
			i = 4 *(k-1) + 3;
			j = 4 * k + 3;
		}
		
		hashTable = new Node[getNearestInt(i,j,n)];
		test = null;
		
	}
	/**
	 * Constructs a CourseDBStructure object without finding the 4k+3 prime 
	 * used as a test to troubleshoot the methods of the class
	 * @param test holds a test string
	 * @param n the length of the hash table 
	 */
	public CourseDBStructure(String test,int n) {
		this.test = test;
		hashTable = new Node[n];
	}
	
	/**
	 * Node is a private inner class that has two attributes:
	 * -  data: the data of the node (CourseDBElement)
	 * - next: the pointer to the next node in a link list : (Node)
	 */
	private class Node{
		CourseDBElement data;
		Node next;
		
		/**
		 * Constructs a Node object with specified data.
		 * Passes in to its own constructor to initialize both attributes 
		 * @param data data of the node
		 */
		private Node(CourseDBElement data) {
			this(data,null);
		}
		/**
		 * Constructs a node with specified data and next node pointer. 
		 * @param data data of the node
		 * @param next points to the next node in link list
		 */
		private Node(CourseDBElement data, Node next) {
			this.data = data; 
			this.next = next;
		}
	}
	
	/**
	 * returns the nearest integer from n 
	 * @param i first integer to be compared
	 * @param j second integer to be compared
	 * @param n the middle point 
	 * @return nearest integer from n 
	 */
	private int getNearestInt(int i, int j, int n) {
		return Math.abs(n - i) < Math.abs(n - j) ? i:j;
	}
	/**
	 * checks if n is a 4k+3 prime
	 * @param n size of the array 
	 * @return true if n is a 4k+3 prime, false otherwise.
	 */
	private boolean is4kp3(int n){
		return (n-3) % 4 == 0 && isPrime(n);
	}
	/**
	 * checks if n is a prime
	 * @param n integer to be check if its prime
	 * @return true if the integer is a prime number, false otherwise.
	 */
	private boolean isPrime(int n) {
		if(n < 2)
			return false;
		
		for(int i = 2; i < Math.sqrt(n);i++) {
			if( n % i == 0)
				return false;
		}
		
		return true;
	}
	
	/**
	 * First, the method takes the hash code of the CRN of the course by turning crn (which is an integer) into a 
	 * string so that the hashCode method can be called and moulo by the hashTable length so the hash is within the length of the array. 
	 * the resulting integer is stored in a variable hashCRN. 
	 * 
	 * The method then checks if at the hashCRN there is a link list. If there is not a link list present, then
	 * the element will be the first node of the link list, and the add method terminates by returning nothing.
	 * 
	 * If there is a element at the hashCRN index, then the compareTo method of CourseDBElement is used to check if its the
	 * exact same object. If the element is exactly the same as the element that is in the first node of the list, the add method 
	 * quietly exits. If the two elements are not exactly the same, but if the crn matches, then the node is updated with the 
	 * information of the specified element. 
	 * 
	 * If the conditions above are not meet at all, then it must mean that there is already an existing node at the hashCRN. This means that the method will 
	 * add a new node to the end of the link list. 
	 * 
	 * The method will iterate through the link list, the method will terminate if the currNode.data element is 
	 * the same as the specified element, or if the crn matches and the node is replaced with a new node that contains the specified element as its
	 * data.
	 * 
	 *  If the function reatches the end, then there is no dupilcate nodes or nodes to be updated, so a node is added
	 *  to the end of the link list.
	 * @param element element of the course. 
	 */
	@Override
	public void add(CourseDBElement element) {
		String stringCRN = String.valueOf(element.getCRN());
		int hashCRN = stringCRN.hashCode() % hashTable.length;
		if(hashTable[hashCRN] == null) {
			hashTable[hashCRN] = new Node(element);
			return;
		}
		
		if(hashTable[hashCRN].data.compareTo(element) == 0) {
			return;
		} else if(hashTable[hashCRN].data.getCRN() == element.getCRN()) {
			Node newNode = new Node(element);
			if(hashTable[hashCRN].next != null)
				newNode.next = hashTable[hashCRN].next;
			hashTable[hashCRN] = newNode;
			return;
		}
		
		
		Node currNode = hashTable[hashCRN];
		while(currNode.next != null) {
			currNode = currNode.next;
			if(currNode.data.compareTo(element) == 0) {
				return;
			} else if (currNode.data.getCRN() == element.getCRN()) {
				Node newNode = new Node(element);	
				newNode.next = currNode.next;
				currNode = newNode;
				return;
			}
			
		}
		
		
		currNode.next = new Node(element);
	}
	/**
	 * Hashes the crn by turning the integer into a string, then calling the object hashCode method.
	 * Using the hased crn and modulo by the length of the hashtable, the method first checks if the 
	 * at the hashCRN index is null. if it is, then IOexception is thrown.
	 * 
	 *If the first node of the bucket matches the specified crn, then that nodes data is returned.
	 *  
	 *The method then iterates through the bucket, once a match is found of crn, then the node that matches
	 *is return and the function is terminated. 
	 *  
	 *if the method reaches the end, then it means that there is no such CourseDBElement with
	 *a matching crn so IOExcpetion is thrown.
	 * 
	 * @param crn the crn of the course
	 * @return Node.data the course with a matching crn
	 * @throws IOException IOException is thrown if there is no such course with specified crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String stringCRN = String.valueOf(crn);
		int hashCRN = stringCRN.hashCode() % hashTable.length;
		
		if(hashTable[hashCRN] == null)
			throw new IOException();
		else if(hashTable[hashCRN].data.getCRN() == crn)
			return hashTable[hashCRN].data;
		
		Node currNode = hashTable[hashCRN];
		while(currNode.next != null) {
			currNode = currNode.next;
			if(currNode.data.getCRN() == crn)
				return currNode.data;
		}
	
		
		throw new IOException(); 
		
	}
	
	/**
	 * Iterates through the array searching for buckets.
	 * 
	 * If there is a bucket at an index, then the bucket link list is iterated, adding each nodes data string to
	 * the allCourses array list.
	 * 
	 *  once the for loop is done, the array list of courses is return with the string format:
	 *  "\n" + "Course:" + courseID + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructor + " Room:" + roomNum.
	 * 
	 * @return allCourses a string array list of the courses.
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> allCourses = new ArrayList<String>();
		for(int i = 0; i < hashTable.length;i++) {
			if(hashTable[i] != null) {
				Node currNode = hashTable[i];
				allCourses.add(currNode.data.toString());
				while(currNode.next != null) {
					currNode = currNode.next;
					allCourses.add(currNode.data.toString());
				}
				
			}
		}
		
		return allCourses;
	}
	/**
	 * returns the length of hashTable 
	 * @return the length of hashTable
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}

}
