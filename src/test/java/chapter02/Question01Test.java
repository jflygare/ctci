package chapter02;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter02.ChapterQuestionBase.Node;

public class Question01Test extends QuestionTestBase<Question01>{

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question01());
	}

	private Node createNode() {
		Node node = new Node(1);
		node.appendToTail(1);
		node.appendToTail(0);
		node.appendToTail(2);
		node.appendToTail(1);
		node.appendToTail(2);
		node.appendToTail(6);
		node.appendToTail(0);
		node.appendToTail(1);
		return node;
	}

	@Test
	public void testRemoveDuplicates() {
		Node n = createNode();
		getQuestionUnderTest().log("Starting List: " + n.toString());
		getQuestionUnderTest().removeDuplicates(n);
		getQuestionUnderTest().log("Ending List: " + n.toString());
		Assert.assertTrue(n.toString().equals("[1][0][2][6]"));
	}

}
