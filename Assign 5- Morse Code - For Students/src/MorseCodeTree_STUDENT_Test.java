import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTree_STUDENT_Test {
	private MorseCodeTree tree;
	@BeforeEach
	void setUp() throws Exception {
		 tree = new MorseCodeTree();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}

	@Test
	void fetchtest() {
		assertEquals("e",tree.fetch("."));
		assertEquals("i",tree.fetch(".."));
		assertEquals("h",tree.fetch("...."));
		assertEquals("g",tree.fetch("--."));
		assertEquals("z",tree.fetch("--.."));
		assertEquals("q",tree.fetch("--.-"));

	}
	@Test
	void insertTest() {
		tree.insert(".---","replaced j");
		assertEquals("replaced j",tree.fetch(".---"));
	
		tree.insert(".....", "λ");
		assertEquals("λ",tree.fetch("....."));
		
		tree.insert("....-", "α");
		assertEquals("α",tree.fetch("....-"));
		
		tree.insert("--.--","γ");
		assertEquals("γ",tree.fetch("--.--"));
		
		tree.insert(".----","δ");
		assertEquals("δ",tree.fetch(".----"));
		
		String output = String.join(" ", tree.toArrayList());
		assertEquals("λ h α s v i f u e l r a p w replaced j δ  b d x n c k y t z g q γ m o",output);	
		
	}
	
	@Test
	void getAndSetRootTest() {
		tree.setRoot(new TreeNode<String>("Replaced root"));
		assertEquals("Replaced root",tree.getRoot().getData());
		
		String output = String.join(" ", tree.toArrayList());
		assertEquals("h s v i f u e l r a p w j Replaced root b d x n c k y t z g q m o",output);	
		
	}

}
