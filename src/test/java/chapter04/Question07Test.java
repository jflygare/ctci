package chapter04;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import chapter04.Question07.CommonAncestorBinaryTree;

import base.QuestionTestBase;

public class Question07Test extends QuestionTestBase<Question07> {


	private static final int INPUT_SIZE = 30;
	private CommonAncestorBinaryTree tree;
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question07());
		Integer[] inputArray = new Integer[INPUT_SIZE];
		for (int i=0; i < INPUT_SIZE; i++) {
			inputArray[i] = i;
		}
		tree = new CommonAncestorBinaryTree(inputArray);
	}
	
	@Test
	public void testCommonAncestor() {
		log(tree.print());
		Assert.assertEquals(Integer.valueOf(14), tree.commonAncestor(1, 29));
		Assert.assertEquals(Integer.valueOf(4), tree.commonAncestor(3, 5));
		Assert.assertEquals(Integer.valueOf(6), tree.commonAncestor(13, 6));
	}
	
}
