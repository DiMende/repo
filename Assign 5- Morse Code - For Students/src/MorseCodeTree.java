import java.util.ArrayList;

/**MorseCodeTree class creates an object that stores each letter in the alphabet as a 
 * node within the tree.
 * 
 * Nodes can be added, but not removed nor updated
 * 
 * Only has one attribute:
 * - treeRoot: root of the tree that holds an empty string value, only
 * serves to be a place holder root for the tree: TreeNode<String>
 * 
 * @author Diego Mendez
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> treeRoot;
	/**
	 * calls the build tree method to create the Morse code binary tree	
	 */
	public MorseCodeTree() {
		buildTree();
	}
	/**
	 * returns the tree root 
	 * @return treeRoot the root of the tree
	 */
	@Override
	public TreeNode<String> getRoot() {
		return treeRoot;
	}

	/**
	 * sets newNode as the new tree root 
	 * @param newNode node that is going to replace treeRoot
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		newNode.setLeft(treeRoot.getLeft()); 
		newNode.setRight(treeRoot.getRight());
		treeRoot = newNode;
	}
	
	/**
	 *calls addNode method and passes in the treeRoot, and the 2 string parameters, code and result 
	 *to insert a new node in the tree  
	 * @param code
	 * @param result
	 */
	@Override
	public void insert(String code, String result) {
		addNode(treeRoot,code,result);
		
	}
	/**
	 * addNode is a recursive method that traverses down the tree to add nodes to the tree. First root is checked if its null, if so
	 * then the method is stopped, if not then the method continues.
	 * If the length of code is equal to 1, then the current root will have new a left child if the single character in code
	 * is a "." or new a right child if the character is a "-". The child will have letter as its data. If the code is longer than 1, then the method instantiates newRoot as 
	 * a TreeNode<String>, then the first character of the code is check to see if its a "." or "-". If the first character is a ".", then 
	 * newRoot is set to the left child of the root, if the first character is "-", then newRoot is set to the right child of the root.
	 * code then removes the first character, then recursively calls addNode and passes in newRoot, which is now the right or left child of the current root,
	 * code which is shorten by one character, and letter which has not changed. this method will continue to call itself until code is one character, in which the
	 * current root will have a new child. 
	 * @param root the current root of the recursion 
	 * @param code the current code of the recursion
	 * @param letter the letter that will be held in the nodes data after being added to the tree
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if(root == null)
			return;
		
		if(code.length() == 1) {
			if(code.charAt(0) == '.') {
				root.setLeft(new TreeNode<String>(letter) );
			} else if (code.charAt(0) == '-') {
				root.setRight(new TreeNode<String>(letter));
			}
		}
		
		if(code.length() > 1) {
			TreeNode<String> newRoot = null;
			if (code.charAt(0) == '.') 
				newRoot = root.getLeft();
			
			if(code.charAt(0) == '-') 
				newRoot = root.getRight();
						
			code = code.substring(1);
			addNode(newRoot,code,letter);
		}
		
		
	}

	/**
	 * Calls fetchNode and passes in tree root and the morse code to 
	 * find and return the morse code translation
	 * @param code the morse code translation of a letter 
	 * @return fetchNode(treeRoot,code) the function calls fetch node which will 
	 * return back the data of node that has the morse code letter translation  
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(treeRoot,code);
	}
	
	/**
	 * Recursively traverses the tree the same way that addNode does.
	 * If the code length is greater than 1, then fetch node is recursively called until code has only one character in the string, while also traversing through the left
	 * or right child depending if the first character is "." or "-". If there is only one character in the string, then the method returns the data of the left or right child, which is then
	 * Recursively returned up the call stack.
	 * @param root the current root
	 * @param code the current code
	 * @return left or right child of the current root
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		
		if(code.length() > 1) {
			if(code.charAt(0) == '.') 
				return fetchNode(root.getLeft(),code.substring(1));
			
			if(code.charAt(0) == '-') 
				return fetchNode(root.getRight(),code.substring(1));
		}
		
		return code.charAt(0) == '.' ?  root.getLeft().getData() : root.getRight().getData();	
		
		
		
	}
	/**Unsupported method
	 * @throws UnsupportedOperationException method is unsupported
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**Unsupported method
	 * @throws UnsupportedOperationException method is Unsupported
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * First the treeRoot is set to a new treeNode that will hold an empty string, then the method 
	 * calls insert for each letter in the alphabet and its morse code translation. To build the tree,
	 * insert is called in level order.  
	 */
	@Override
	public void buildTree() {
		treeRoot = new TreeNode<String>("");
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}
	
	/**
	 * Calls LNRoutputTraversal to store the tree as inorder traversal in lnr
	 * @return lnr a string array list that holds the binary tree as inorder traversal
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> lnr = new ArrayList<String>();
		LNRoutputTraversal(treeRoot,lnr);
		return lnr;
	}
	
	/**
	 * traverses the binary tree in order, first the method traverse all the way to 
	 * the left most bottom node, and traverses to the left, parent, then right nodes.
	 * stores each of the nodes data in list. 
	 * @param root the current root
	 * @param list the list that is going to store each data of the node
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.getLeft() != null)
			LNRoutputTraversal(root.getLeft(),list);
		
		list.add(root.getData());

		if(root.getRight() != null)
			LNRoutputTraversal(root.getRight(),list);
	
	}
	
	

}
