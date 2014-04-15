package chapter01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import base.QuestionTestBase;

public class Question01Test extends QuestionTestBase<Question01>{

	String ONE_SPACE = "abcde fghij";
	String SIMPLE_FAIL = "aa";
	String DOUBLE_LETTER = "letter";
	String TWO_SPACES = "big  space";
	String SEPARATE_WORDS = "kit cat"; // T is repeated on separate words
	
	final String[] passStrings = new String[] {
			ONE_SPACE
	};
	
	final String[] failStrings = new String[] {
			SIMPLE_FAIL,
			DOUBLE_LETTER,
			TWO_SPACES,
			SEPARATE_WORDS
	};
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question01());
	}
	
	@Test
	public void testHasAllUniqueCharactersBruteForce() {
		for (String string : passStrings) {
			assertTrue(string, getQuestionUnderTest().hasAllUniqueCharactersBruteForce(string));
		}
		for (String string : failStrings) {
			assertFalse(string, getQuestionUnderTest().hasAllUniqueCharactersBruteForce(string));
		}
	}

	@Test
	public void testHasAllUniqueCharactersBookAnswer1() {
		for (String string : passStrings) {
			assertTrue(string, getQuestionUnderTest().hasAllUniqueCharactersBookAnswer1(string));
		}
		for (String string : failStrings) {
			assertFalse(string, getQuestionUnderTest().hasAllUniqueCharactersBookAnswer1(string));
		}
	}
	
	@Test
	@Ignore // Does not work for sapces
	public void testHasAllUniqueCharactersBookAnswer2() {
		for (String string : passStrings) {
			assertTrue(string, getQuestionUnderTest().hasAllUniqueCharactersBookAnswer2(string));
		}
		for (String string : failStrings) {
			assertFalse(string, getQuestionUnderTest().hasAllUniqueCharactersBookAnswer2(string));
		}
	}

	@Test
	public void testHasAllUniqueCharactersRegex() {
		for (String string : passStrings) {
			assertTrue(string, getQuestionUnderTest().hasAllUniqueCharactersRegularExpression(string));
		}
		for (String string : failStrings) {
			assertFalse(string, getQuestionUnderTest().hasAllUniqueCharactersRegularExpression(string));
		}
	}
	
	

}
