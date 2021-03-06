package chapter02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter02.ChapterQuestionBase.Node;

public class Question06Test extends QuestionTestBase<Question06> {

	private Node n1;

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question06());
		n1 = new Node('A');
		n1.appendToTail('B');
		Node nc = n1.appendToTail('C');
		n1.appendToTail('D');
		n1.appendToTail('E').next = nc; // Create loop

	}

	@Test
	public void testFindCircularNode() {
		Node nc = getQuestionUnderTest().findCircularNode(n1);
		Assert.assertNotNull(nc);
		Assert.assertTrue(nc.data == 'C');
	}

}
