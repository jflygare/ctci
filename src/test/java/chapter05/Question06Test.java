package chapter05;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question06Test extends QuestionTestBase<Question06> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question06());
	}

	@Test
	public void testSwapBits() {
		int num = 857;  //1101011001
		int swap = 934; //1110100110
		int result = getQuestionUnderTest().swapBits(num);
		Assert.assertEquals(swap, result);
	}

	@Test
	public void testSwapOddEvenBits() {
		int num = 857;  //1101011001
		int swap = 934; //1110100110
		int result = getQuestionUnderTest().swapOddEvenBits(num);
		Assert.assertEquals(swap, result);
	}
}
