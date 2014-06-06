package chapter05;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question08Test extends QuestionTestBase<Question08> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question08());
	}

	private byte[] createTestScreen(int height, int width) {
		byte[] screen = new byte[height * (width / Question08.PIXEL_BITS)];
		return screen;
	}

	@Test
	public void testDrawHorizontalLine() {
		int width = 3 * Question08.PIXEL_BITS;
		int height = width;
		byte[] screen = createTestScreen(height, width);
		log("Empty Screen:");
		log(getQuestionUnderTest().printScreen(screen, width));
		getQuestionUnderTest().drawHorizontalLine(screen, width, 6, 18, 9);
		log("\n\nDrawn Screen:");
		log(getQuestionUnderTest().printScreen(screen, width));
	}
}
