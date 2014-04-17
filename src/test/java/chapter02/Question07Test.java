package chapter02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter02.ChapterQuestionBase.DNode;

public class Question07Test extends QuestionTestBase<Question07> {

	private DNode dn;

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question07());
		dn = new DNode('A');
		dn.appendToTail('B');
		dn.appendToTail('C');
		dn.appendToTail('D');
		dn.appendToTail('E');
		dn.appendToTail('D');
		dn.appendToTail('C');
		dn.appendToTail('B');
		dn.appendToTail('A');
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(getQuestionUnderTest().isPalindrome(dn));
		assertFalse(getQuestionUnderTest().isPalindrome((DNode) dn.appendToTail('X')));
	}

}
