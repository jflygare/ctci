package chapter01;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Question05Test {

	@SuppressWarnings("serial")
	private Map<String, String> examplesMap = new HashMap<String, String>() {
		{
			put("aabcccccaaa", "a2b1c5a3");
			put("abcdefghijk", "abcdefghijk");
			put("aabbccddeeffgghhiijjkk", "aabbccddeeffgghhiijjkk");
		}
	};

	private Question05 sut = new Question05();

	@Test
	public void testCompressShortAnswer() {
		for (String input : examplesMap.keySet()) {
			assertEquals(examplesMap.get(input), sut.compressShortAnswer(input));
		}
	}

	@Test
	public void testCompress() {
		for (String input : examplesMap.keySet()) {
			assertEquals(examplesMap.get(input), sut.compress(input));
		}
	}

}
