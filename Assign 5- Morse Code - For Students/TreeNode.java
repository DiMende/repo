
public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;
	
	
	public T getData(){
		return data;
	}
	public TreeNode<T> getLeft(){
		return left;
	}
	public void setLeft(TreeNode<T> node) {
		left = node;
	}
}	
	
