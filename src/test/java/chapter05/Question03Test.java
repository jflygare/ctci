package chapter05;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import base.QuestionTestBase;

public class Question03Test extends QuestionTestBase<Question03> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question03());
	}

	@Test
	public void testBruteForce() {
		int num = 26;
		int next = 28;
		int prev = 25;

		int n = getQuestionUnderTest().bruteNext(num);
		int p = getQuestionUnderTest().brutePrev(num);

		log(num + ": [prev = " + p + "] [next = " + n + "]");

		Assert.assertEquals(next, n);
		Assert.assertEquals(prev, p);
	}

	@Test
	@Ignore
	public void testAllIntegers() {
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			int n = getQuestionUnderTest().bruteNext(i);
			int p = getQuestionUnderTest().brutePrev(i);

			log(i + ": [prev = " + p + "] [next = " + n + "]");
		}
	}
}
