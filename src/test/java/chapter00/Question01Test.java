package chapter00;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import base.QuestionTestBase;

public class Question01Test extends QuestionTestBase<Question01> {
	
	public void calcTest(int hour, int minute, int angle) {
		setQuestionUnderTest(new Question01(hour, minute));
		assertEquals(angle, getQuestionUnderTest().calculateHandAngle());
		assertEquals(angle, getQuestionUnderTest().bookAnswer());
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
	
	@Test
	public void test0427() {
		calcTest(4, 27, 42);
	}

}
