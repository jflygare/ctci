package chapter03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chapter03.ChapterQuestionBase.Generics;

public class Question06Test {

	private Question06 sut = new Question06();
	private Generics.Stack<Integer> stack = new Generics.Stack<Integer>();

	@Before
	public void setUp() {
		stack.push(0);
		stack.push(5);
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(7);
		stack.push(8);
		stack.push(6);
		stack.push(4);
		stack.push(9);
	}

	@Test
	public void testSortStack() {
		// Sort the stack (desc)
		sut.sortStack(stack);
		for (int i = 9; i >= 0; i--) {
			sut.log(i + " = " + stack.peek());
			assertEquals((Integer) i, stack.pop());
		}
	}

}
