package chapter05;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question01Test extends QuestionTestBase<Question01> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question01());
	}
	
	@Test
	public void testInsertBits() {
		int n = 1024; //10000000000
		int m = 19; //10011
		int i = 2;
		int j = 6;
		int answer = 1100; //10001001100
		
		int result = getQuestionUnderTest().insertBits(n, m, i, j);
		Assert.assertEquals(answer, result);
	}
}
