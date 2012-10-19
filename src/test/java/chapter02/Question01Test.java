package chapter02;

import junit.framework.Assert;

import org.junit.Test;

import chapter02.ChapterQuestionBase.Node;

public class Question01Test {

	private Question01 sut = new Question01();

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
		sut.log("Starting List: " + n.toString());
		sut.removeDuplicates(n);
		sut.log("Ending List: " + n.toString());
		Assert.assertTrue(n.toString().equals("[1][0][2][6]"));
	}

}
