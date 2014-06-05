package chapter05;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question05Test extends QuestionTestBase<Question05> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question05());
	}

	@Test
	public void testConvertBits() {
		int count = getQuestionUnderTest().convertBits(31, 14);
		Assert.assertEquals(2, count);
	}
}
