package chapter01;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question04Test extends QuestionTestBase<Question04>{
	
	private String INPUT = "Mr John Smith    ";
	private String OUTPUT = "Mr%20John%20Smith";
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question04());
	}

	@Test
	public void testEncode() {
		char[] input = INPUT.toCharArray();
		getQuestionUnderTest().encode(input);
		assertTrue(Arrays.equals(OUTPUT.toCharArray(), input));
	}

	@Test
	public void testEncodeBookAnswer() {
		// Manipulate input to match expected condition...
		char[] input = "Mr John Smith".toCharArray();
		char[] padded = Arrays.copyOf(input, input.length + 10); // arbitrary, but long enough
		getQuestionUnderTest().encodeBookAnswer(padded, 13);
		String result = new String(padded).trim();
		assertEquals(OUTPUT, result);
	}

}
