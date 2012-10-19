package chapter02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chapter02.ChapterQuestionBase.Node;

public class Question02Test {

	private Question02 sut = new Question02();

	private Node createNode() {
		Node node = new Node(0);
		node.appendToTail(1);
		node.appendToTail(2);
		node.appendToTail(3);
		node.appendToTail(4);
		node.appendToTail(5);
		node.appendToTail(6);
		node.appendToTail(7);
		node.appendToTail(8);
		return node;
	}

	@Test
	public void testEndIndex() {
		Node n = createNode();
		sut.log("Node list: " + n);
		assertEquals(5, sut.endIndexFastAnswer(n, 3).data);
	}

	@Test
	public void testEndIndexPrimitive() {
		Node n = createNode();
		sut.log("Node list: " + n);
		assertEquals(5, sut.endIndex(n, 3).data);
	}

}
