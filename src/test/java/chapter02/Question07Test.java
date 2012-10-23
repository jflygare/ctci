package chapter02;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import chapter02.ChapterQuestionBase.DNode;

public class Question07Test {

	private Question07 sut = new Question07();
	private DNode dn;

	@Before
	public void setUp() {
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
		assertTrue(sut.isPalindrome(dn));
		assertFalse(sut.isPalindrome((DNode) dn.appendToTail('X')));
	}

}
