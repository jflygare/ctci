package chapter01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question08Test extends QuestionTestBase<Question08> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question08());
	}

	@Test
	public void testIsRotation() {
		assertTrue(getQuestionUnderTest().isRotation("waterbottle", "erbottlewat"));
		assertTrue(getQuestionUnderTest().isRotation("waterbottle", "terbottlewa"));
		assertTrue(getQuestionUnderTest().isRotation("waterbottle", "aterbottlew"));
		assertTrue(getQuestionUnderTest().isRotation("waterbottle", "waterbottle"));
		assertFalse(getQuestionUnderTest().isRotation("waterbottle", "bottlewaterbottle"));
	}

}
