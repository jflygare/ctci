package chapter03;

import org.junit.Assert;
import org.junit.Test;

import chapter03.Question04.Hanoi;

public class Question04Test {

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
