package chapter03;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question01Test extends QuestionTestBase<Question01> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question01());
	}

	@Test
	public void test() {
		getQuestionUnderTest().log("Not writing any code for question");
	}

}
