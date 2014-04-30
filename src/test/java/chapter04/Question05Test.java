package chapter04;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import chapter04.Question05.BinarySearchTree;
import base.QuestionTestBase;

public class Question05Test extends QuestionTestBase<Question05> {

	private static final int INPUT_SIZE = 30;
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question05());
	}
	
	private BinarySearchTree createTree(boolean isBST) {
		int size = (isBST) ? INPUT_SIZE : INPUT_SIZE +1;
		Integer[] inputArray = new Integer[size];
		for (int i=0; i < size; i++) {
			inputArray[i] = i;
		}
		if (!isBST) {
			// Put 0 all the way to the right
			inputArray[size -1] = 0;
		}
		return new BinarySearchTree(inputArray);
	}
	
	@Test
	public void testIsBST() {
		BinarySearchTree tree = createTree(true);
		log(tree.print());
		Assert.assertTrue(tree.isBST());
	}
	
	@Test
	public void testIsNotBST() {
		BinarySearchTree tree = createTree(false);
		log(tree.print());
		Assert.assertFalse(tree.isBST());
	}
}
