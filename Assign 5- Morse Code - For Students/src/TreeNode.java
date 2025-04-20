/**
 * TreeNode class is a public generic class that is used to create nodes 
 * for the morse code tree.
 * 
 * Has 3 attributes:
 * - data: stores the data for the node:T
 * - left: used to point to the "left" child of the node: TreeNode<T>
 * - right: used to point to the "right" child of the node: TreeNode<T>
 * 
 * @author Diego Mendez
 * @param <T> the generic object for the node
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	/**
	 * creates a TreeNode object with only data, and then 
	 * calls its other constructor to pass in null for both the left and right node
	 * @param data data of the node
	 */
	public TreeNode(T data){
		this(data,null,null);
	}
	/**
	 * constructor for deep cloning 
	 * @param node node that is going to be deep cloned
	 */
	public TreeNode(TreeNode<T> node) {
		TreeNode<T> copyNode = new TreeNode<T>(node.getData(),node.getLeft(),node.getRight());
	}
	/**
	 * constructs a tree node with data, left and right child instantiated 
	 * @param data the data of the node
	 * @param left the left node child
	 * @param right the right node child
	 */
	public TreeNode(T data,TreeNode<T> left,TreeNode<T> right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Setter method for data
	 * @param data sets data of the node to parameter data 
	 */
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Getter method for data
	 * @return data data of the node
	 */
	public T getData(){
		return data;
	}
	/**
	 * getter method that returns the left child of parent node
	 * @return left, the left child of the parent node
	 */
	public TreeNode<T> getLeft(){
		return left;
	}
	/**
	 * sets the parameter left to the left node of parent
	 * @param left, left node that is going to be connected to the parent node 
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}
	/**
	 * sets the parameter right to the left node of parent
	 * @param right, right node that is going to be connected to the parent node 
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}
	/**
	 * getter method that returns the right child of parent node
	 * @return right, the right child of the parent node
	 */
	public TreeNode<T> getRight(){
		return right;
	}
	
	
}	
	
