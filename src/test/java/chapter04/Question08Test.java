package chapter04;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import chapter04.Question03.BinarySearchTree;

import base.QuestionTestBase;

public class Question08Test extends QuestionTestBase<Question08> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question08());
	}
	
	private BinarySearchTree<Integer> createTree(int size) {
		//Using Tree from chap3 for convenience
		Integer[] inputArray = new Integer[size];
		for (int i=0; i < size; i++) {
			inputArray[i] = i;
		}
		return new BinarySearchTree<Integer>(inputArray);
	}
	
	@Test
	public void testIsSubtree() {
		BinarySearchTree<Integer> largeTree = createTree(62);
		BinarySearchTree<Integer> smallTree = createTree(7);
		log("Looking for small tree:");
		log(smallTree.print());
		log("in big tree:");
		log(largeTree.print());
		
		Assert.assertTrue(getQuestionUnderTest().isSubtree(largeTree.getRoot(), smallTree.getRoot()));
	}
}
