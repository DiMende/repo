import java.util.*;

public class HuffmanTree {
	
	private String sentence;
	private TreeNode root;
	
	public HuffmanTree(String s) {
		sentence = s;
	}
	
	public HuffmanTree() {
		this(null);
	}
	
	public void setSentence(String s) {
		sentence = s;
	}
	
	public void createTree(){
		
		Queue<TreeNode> q1 = makeQueue();

		while(q1.size() > 1) {
			TreeNode t1 = q1.remove();
			TreeNode t2 = q1.remove();		
			q1.add(createSubTree(t1,t2));	
		}
		
		root = q1.remove();
		
	}
	
	public Queue<TreeNode> makeQueue(){
		HashMap<Character,Integer> hashM = new HashMap<>();
		int x = 0;
		int y = 0;
		for(int i = 0; i < sentence.length();i++) {
			if( !hashM.containsKey(sentence.charAt(i) ) ) { 
				hashM.put(sentence.charAt(i),1);
			}else if (hashM.containsKey(sentence.charAt(i)) ){
				x = hashM.get(sentence.charAt(i));	
				y = x + 1;
				hashM.replace(sentence.charAt(i), x, y);
			}
		}
		
		Set<Character> keySet =  hashM.keySet();
		Queue<TreeNode> priorityQ = new PriorityQueue<>();
		
		for(Character i:keySet) 
			priorityQ.add(new TreeNode(new HuffmanChar(i,hashM.get(i))) );
		
		return priorityQ;
	}
	
	public TreeNode createSubTree(TreeNode left,TreeNode right) {
		
		TreeNode tempHead = new TreeNode(new HuffmanChar('-',left.getData().getFreqeuency()+right.getData().getFreqeuency()));
		tempHead.setLeft(left);
		tempHead.setRight(right);
		
		return tempHead;
	}
	
	public ArrayList<String> toArrayList(){
		ArrayList<String> l = new ArrayList<String>();
		IOT(root,l);
		return l;
	}
	
	public void IOT(TreeNode subRoot,ArrayList<String> treeList) {
		if(subRoot.getLeft() != null)
			 IOT(subRoot.getLeft(),treeList);
		
		treeList.add(subRoot.getData().toString());
		
		if(subRoot.getRight() != null)
			 IOT(subRoot.getRight(),treeList);
		
	}
	
	
	
}
