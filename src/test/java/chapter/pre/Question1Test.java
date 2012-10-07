package chapter.pre;

import static org.junit.Assert.*;

import org.junit.Test;

public class Question1Test {
	
	public void calcTest(int hour, int minute, int angle) {
		assertEquals(angle, new Question1(hour, minute).calculateHandAngle());
		//assertEquals(angle, new Question1(hour, minute).bookAnswer());
	}

	@Test
	public void test1215() {
		calcTest(12, 15, 90);
	}
	
	@Test
	public void test0300() {
		calcTest(3,0,90);
	}
	
	@Test
	public void test1230() {
		calcTest(12, 30, 180);
	}
	
	@Test
	public void test0107() {
		calcTest(1, 7, 12);
	}

}
