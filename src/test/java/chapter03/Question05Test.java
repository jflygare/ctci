package chapter03;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chapter03.Question05.MyQueue;

public class Question05Test {

	@Test
	public void test() {
		int size = 10;
		MyQueue<Integer> sut = new MyQueue<Integer>();
		// Add in ascending order
		for (int i = 0; i < size; i++) {
			sut.enqueue(i);
		}
		// Test for ascending order
		for (int i = 0; i < size; i++) {
			assertEquals((Integer) i, sut.unqueue());
		}
	}

}
