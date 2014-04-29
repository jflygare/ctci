package chapter04;

import org.junit.Before;
import org.junit.Test;

import chapter04.Question03.BinarySearchTree;

import base.QuestionTestBase;

public class Question03Test extends QuestionTestBase<Question03> {
	
	private static final int INPUT_SIZE = 30;
	private Integer[] inputArray;
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question03());
		
		inputArray = new Integer[INPUT_SIZE];
		for (int i=0; i < INPUT_SIZE; i++) {
			inputArray[i] = i;
		}
	}
	
	@Test
	public void testArrayToTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(inputArray);
		log(tree.print());
	}
}
