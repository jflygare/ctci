package chapter01;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question02Test {
	
	private Question02 sut = new Question02();

	@Test
	public void testProcess() {
		Question02.process(null, 0);
	}

}
