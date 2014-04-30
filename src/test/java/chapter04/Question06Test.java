package chapter04;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import chapter04.Question06.NextSuccessorTree;

import base.QuestionTestBase;

public class Question06Test extends QuestionTestBase<Question06> {


	private static final int INPUT_SIZE = 30;
	private NextSuccessorTree tree;
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question06());
		Integer[] inputArray = new Integer[INPUT_SIZE];
		for (int i=0; i < INPUT_SIZE; i++) {
			inputArray[i] = i;
		}
		tree = new NextSuccessorTree(inputArray);
	}
	
	@Test
	public void testNextSuccessor() {
		log(tree.print());
		
		for (int i=0; i < INPUT_SIZE -1; i++) {
			Assert.assertEquals(Integer.valueOf(i + 1), tree.getNext(i));
		}
	}
	
}
