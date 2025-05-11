import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HuffmanTree_Test {

	HuffmanTree huffTree;
	String s1,s2,s3;
	@BeforeEach
	void setUp() throws Exception {
		s1 = "create a huffman tree";
		s2 = "Hello my darling";
		s3 = "Jump and go to the zoo";
		huffTree = new HuffmanTree();
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		s3 = null;
		huffTree = null;
		
	}

	@Test
	public void createQTest() {
		huffTree.setSentence(s1);
		Queue<TreeNode> q = huffTree.makeQueue();
		assertEquals("e 4",q.peek().getData().toString());
		assertEquals(11,q.size());
		ArrayList<TreeNode> t = new ArrayList<>();
		while(!q.isEmpty())
			t.add(q.remove());
		assertEquals(11,t.size());
		String s = "";
	
		for(int i = 0; i < q.size();i++) 
			s += q.remove().getData().toString() + " ";
		assertEquals("c 1 h 1 m 1 n 1 u 1 f 2 r 2 t 2  3 a 3 e 4",s);
	}
	
	@Test
	void createTreetest() {
		huffTree.setSentence(s1);
		huffTree.createTree();
		ArrayList<String> s1Tree = huffTree.toArrayList();
		String s = "";
		for(String i : s1Tree)
			s += i + " ";
			
		assertEquals("s",s);
	}

}
