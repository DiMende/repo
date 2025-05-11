
public class TreeNode implements Comparable<TreeNode>{
	private TreeNode left;
	private TreeNode right;
	private HuffmanChar data;
	

	
	public TreeNode(HuffmanChar letter) {
		this(null,null,letter);
	}
	public TreeNode(TreeNode left,TreeNode right) {
		this(left,right,null);
	}
	
	public TreeNode(TreeNode left,TreeNode right,HuffmanChar c) {
		this.left = left; 
		this.right = right;
		data = c;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setRight(TreeNode n) {
		right = n;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode n) {
		left = n;
	}
	
	public HuffmanChar getData() {
		return data;
	}
	
	public void setData(HuffmanChar d) {
		 data = d;
	}
	@Override
	public int compareTo(TreeNode o) {
		if(this.data.compareTo(o.data) != 0)
			return this.data.compareTo(o.data);
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null || getClass() != o.getClass())
			return false;
		TreeNode t = (TreeNode) o;
		return this.data.equals(t.data);
		
		
	}

		
}