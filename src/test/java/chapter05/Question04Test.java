package chapter05;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question04Test extends QuestionTestBase<Question04> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question04());
	}

	@Test
	public void testAnswer() {
		log(getQuestionUnderTest().answer());
	}
}
