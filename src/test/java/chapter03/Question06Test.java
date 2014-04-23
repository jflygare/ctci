package chapter03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter03.ChapterQuestionBase.Generics;

public class Question06Test extends QuestionTestBase<Question06> {

	private Generics.Stack<Integer> stack = new Generics.Stack<Integer>();

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question06());
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
		getQuestionUnderTest().sortStack(stack);
		for (int i = 9; i >= 0; i--) {
			getQuestionUnderTest().log(i + " = " + stack.peek());
			assertEquals((Integer) i, stack.pop());
		}
	}

}
