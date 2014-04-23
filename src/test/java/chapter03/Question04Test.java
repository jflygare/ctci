package chapter03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter03.Question04.Hanoi;

public class Question04Test extends QuestionTestBase<Question04>{

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question04());
	}
	private int MAX_RINGS = 15;

	@Test
	public void test() {
		for (int i = 0; i < MAX_RINGS; i++) {
			int rings = i;
			int expectedMoves = (int) (Math.pow(2, rings) - 1);
			Hanoi sut = new Hanoi(rings);
			int moves = sut.solve();
			Assert.assertEquals(expectedMoves, moves);
		}
	}

}
