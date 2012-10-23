package chapter02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import chapter02.ChapterQuestionBase.Node;

public class Question05Test {

	private Question05 sut = new Question05();
	private Node n1;
	private Node n2;

	@Before
	public void setUp() {
		n1 = new Node(7);
		n1.appendToTail(1);
		n1.appendToTail(6);

		n2 = new Node(5);
		n2.appendToTail(9);
		n2.appendToTail(2);
	}

	@Test
	public void testAdd() {
		Node n3 = sut.add(n1, n2);
		sut.log(n1 + " + " + n2 + " = " + n3);
		assertEquals("[1][3][0][8]", n3.toString());
	}

	@Test
	public void testAddReversed() {
		n2.appendToTail(1); // Add digit to make uneven
		Node n3 = sut.addReversed(n1, n2);
		sut.log(n1 + " + " + n2 + " = " + n3);
		assertEquals("[2][1][9][1]", n3.toString());
	}

}
