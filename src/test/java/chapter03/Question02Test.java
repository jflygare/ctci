package chapter03;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter03.Question02.MStack;

public class Question02Test extends QuestionTestBase<Question02>{

	private MStack sut = new MStack();

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question02());
		sut.push(3); // 3
		sut.push(6); // 3
		sut.push(2); // 2
		sut.push(3); // 2
		sut.push(7); // 2
		sut.push(1); // 1
		sut.push(8); // 1
	}

	@Test
	public void test() {
		assertTrue(sut.min() == 1);
		assertTrue(sut.pop().equals(8));
		assertTrue(sut.min() == 1);
		assertTrue(sut.pop().equals(1));
		assertTrue(sut.min() == 2);
		assertTrue(sut.pop().equals(7));
		assertTrue(sut.min() == 2);
		assertTrue(sut.pop().equals(3));
		assertTrue(sut.min() == 2);
		assertTrue(sut.pop().equals(2));
		assertTrue(sut.min() == 3);
		assertTrue(sut.pop().equals(6));
		assertTrue(sut.min() == 3);
		assertTrue(sut.pop().equals(3));
		assertTrue(sut.min() == null);
		assertTrue(sut.pop() == null);
	}

}
