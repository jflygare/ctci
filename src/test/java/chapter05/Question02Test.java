package chapter05;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question02Test extends QuestionTestBase<Question02> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question02());
	}

	@Test
	public void testPrintBinary() {
		String bin = getQuestionUnderTest().printBinary(.72);
		log(bin);
		// Nothing to assert since this code does not make sense anyway.
	}
}
