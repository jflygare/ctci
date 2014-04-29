package chapter04;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import chapter04.Question02.IncidenceGraph;

import base.QuestionTestBase;

public class Question02Test extends QuestionTestBase<Question02> {
	
	private IncidenceGraph<Integer> graph;

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question02());
		graph = new IncidenceGraph<Integer>();
		graph.connect(1, 2);
		graph.connect(1, 3);
		graph.connect(2, 4);
		graph.connect(4, 5);
		graph.connect(3, 5);
		// Disconnected nodes
		graph.connect(6, 7);
	}
	
	@Test
	public void testIsConnected() {
		Assert.assertTrue(graph.isConnected(1, 5));
		Assert.assertFalse(graph.isConnected(1, 7));
	}
	
	
}
