package chapter02;

import junit.framework.Assert;

import org.junit.Test;

import chapter02.ChapterQuestionBase.Node;

public class Question03Test {

	private Question03 sut = new Question03();

	@Test
	public void testDeleteNode() {
		Node node = new Node('a');
		node.appendToTail('b');
		Node middle = node.appendToTail('c');
		node.appendToTail('d');
		node.appendToTail('e');
		sut.log("Initial list: " + node.toCharString());
		sut.log("Removing node: " + (char) middle.data);
		sut.deleteNode(middle);
		sut.log("New list: " + node.toCharString());
		Assert.assertEquals("[a][b][d][e]", node.toCharString());
	}

}
