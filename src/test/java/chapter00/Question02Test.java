package chapter00;

import static org.junit.Assert.*;

import org.junit.Test;

import chapter00.Question02;

public class Question02Test {
	
	@Test
	public void minElementTest() {
		assertEquals(1, new Question02().minElement());
	}
}
