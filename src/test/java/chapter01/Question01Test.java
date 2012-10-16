package chapter01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Question01Test {

	Question01 sut = new Question01();

	String ONE_SPACE = "abcde fghij";
	String SIMPLE_FAIL = "aa";
	String DOUBLE_LETTER = "letter";
	String TWO_SPACES = "big  space";
	String SEPARATE_WORDS = "kit cat"; // T is repeated on separate words

	@Test
	public void testHasAllUniqueCharactersShortAnswer() {
		assertTrue(sut.hasAllUniqueCharactersShortAnswer(ONE_SPACE));
		assertFalse(sut.hasAllUniqueCharactersShortAnswer(SIMPLE_FAIL));
		assertFalse(sut.hasAllUniqueCharactersShortAnswer(DOUBLE_LETTER));
		assertFalse(sut.hasAllUniqueCharactersShortAnswer(TWO_SPACES));
		assertFalse(sut.hasAllUniqueCharactersShortAnswer(SEPARATE_WORDS));
	}

	@Test
	public void testHasAllUniqueCharacters() {
		assertTrue(sut.hasAllUniqueCharacters(ONE_SPACE));
		assertFalse(sut.hasAllUniqueCharacters(SIMPLE_FAIL));
		assertFalse(sut.hasAllUniqueCharacters(DOUBLE_LETTER));
		assertFalse(sut.hasAllUniqueCharacters(TWO_SPACES));
		assertFalse(sut.hasAllUniqueCharacters(SEPARATE_WORDS));
	}

}
