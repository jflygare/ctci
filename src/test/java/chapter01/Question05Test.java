package chapter01;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question05Test extends QuestionTestBase<Question05>{

	@SuppressWarnings("serial")
	private Map<String, String> examplesMap = new HashMap<String, String>() {
		{
			put("aabcccccaaa", "a2b1c5a3");
			put("abcdefghijk", "abcdefghijk");
			put("aabbccddeeffgghhiijjkk", "aabbccddeeffgghhiijjkk");
		}
	};

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question05());
	}

	@Test
	public void testCompressShortAnswer() {
		for (String input : examplesMap.keySet()) {
			assertEquals(examplesMap.get(input), getQuestionUnderTest().compressShortAnswer(input));
		}
	}

	@Test
	public void testCompress() {
		for (String input : examplesMap.keySet()) {
			assertEquals(examplesMap.get(input), getQuestionUnderTest().compress(input));
		}
	}

}
