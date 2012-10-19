package chapter02;

import junit.framework.Assert;

import org.junit.Test;

import chapter02.ChapterQuestionBase.Node;

public class Question04Test {

	private Question04 sut = new Question04();

	private Node createNode() {
		Node node = new Node(1);
		node.appendToTail(7);
		node.appendToTail(0);
		node.appendToTail(2);
		node.appendToTail(5);
		node.appendToTail(3);
		node.appendToTail(6);
		node.appendToTail(8);
		node.appendToTail(4);
		return node;
	}

	@Test
	public void testPartitionFastAnswer() {
		Node node = createNode();
		sut.log("Input list:       " + node);
		Node pNode = sut.partitionFastAnswer(node, 4);
		sut.log("Partitioned list: " + pNode);
		Assert.assertEquals("[3][2][0][1][7][5][6][8][4]", pNode.toString());
	}

	@Test
	public void testPartition() {
		Node node = createNode();
		sut.log("Input list:       " + node);
		Node pNode = sut.partition(node, 4);
		sut.log("Partitioned list: " + pNode);
		Assert.assertEquals("[3][2][0][1][7][5][6][8][4]", pNode.toString());
	}

}
