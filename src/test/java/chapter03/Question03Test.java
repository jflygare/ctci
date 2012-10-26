package chapter03;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import chapter03.Question03.SetOfStacks;

public class Question03Test {

	private SetOfStacks<Integer> sut;

	@Before
	public void setUp() {
		sut = new SetOfStacks<Integer>(10);
		for (int i = 0; i < 100; i++) {
			sut.push(i);
		}
	}

	@Test
	public void test() {
		sut.log(sut.toString());

		for (int i = 0; i < 100; i++) {
			Random rand = new Random();
			int j = rand.nextInt(10);
			try {
				sut.popFromStack(j);
				sut.log("-------------- " + i + " -----------------");
				sut.log(sut.toString());
			} catch (IndexOutOfBoundsException e) {
				// Expected.
			}
		}
	}

}
