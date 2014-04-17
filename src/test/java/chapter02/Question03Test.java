package chapter02;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter02.ChapterQuestionBase.Node;

public class Question03Test extends QuestionTestBase<Question03> {
	
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question03());
	}
	
	@Test
	public void testDeleteNode() {
		Node node = new Node('a');
		node.appendToTail('b');
		Node middle = node.appendToTail('c');
		node.appendToTail('d');
		node.appendToTail('e');
		getQuestionUnderTest().log("Initial list: " + node.toCharString());
		getQuestionUnderTest().log("Removing node: " + (char) middle.data);
		getQuestionUnderTest().deleteNode(middle);
		getQuestionUnderTest().log("New list: " + node.toCharString());
		Assert.assertEquals("[a][b][d][e]", node.toCharString());
	}

}
