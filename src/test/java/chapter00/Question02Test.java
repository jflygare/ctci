package chapter00;

import static org.junit.Assert.*;

import org.junit.Test;

import base.QuestionTestBase;

import chapter00.Question02;

public class Question02Test extends QuestionTestBase<Question02> {
	

	// private Set<Integer> set;
	private int[] set = new int[] { 3, 4, 5, 6, 7, 1, 2 };
	
	@Test
	public void minElementTest() {
		setQuestionUnderTest(new Question02());
		assertEquals(1, getQuestionUnderTest().findMinElement(set));
	}
}
