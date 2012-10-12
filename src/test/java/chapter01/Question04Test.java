package chapter01;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Question04Test {
	
	private Question04 sut = new Question04();
	private String INPUT = "Mr John Smith    ";
	private String OUTPUT = "Mr%20John%20Smith";

	@Test
	public void testEncode() {
		char[] input = INPUT.toCharArray();
		sut.encode(input);
		assertTrue(Arrays.equals(OUTPUT.toCharArray(), input));
	}

}
