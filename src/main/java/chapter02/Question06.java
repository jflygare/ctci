package chapter02;

import java.util.HashSet;
import java.util.Set;

import base.BigO;

public class Question06 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given a circular linked list, implement an algorithm which returns "
				+ "the node at the beginning of the loop. DEFINITION: Cicular linked list: "
				+ "A (corrupt) linked list in qhich a node's next pointer points to "
				+ "an earlier node, so as to make a loop in the linked list. EXAMPLE: "
				+ "Input: A->B->C->D->E->C [the same C as earlier]. Output: C";
	}

	public Node findCircularNode(Node n1) {
		// Build a set of reference pointers and check if found already while
		// iterating through list
		Set<Node> nodeSet = new HashSet<Node>(); //O(N) space
		while (n1 != null) { //O(N) Time
			log("Visited node: " + (char) n1.data);
			if (nodeSet.contains(n1)) {
				log("Circular node = " + (char) n1.data);
				return n1;
			} else {
				nodeSet.add(n1); //O(1) Time
				n1 = n1.next;
			}
		}
		// No recursive nodes found
		return null;
		
		// This runs in O(N) time and O(N) space
	}

	/*
	 * AFTER READING THE BOOK: They recommend an algorithm using 2 runners at
	 * different speeds and determining loop start based on collisions. This is
	 * better in that it requires no extra space. The book solution would still
	 * run in O(N) time as the worst case would be a 2 node loop at the very end of
	 * the list. Meaning the slow-runner would still need to traverse the whole list
	 * in order to catch up with fast-runner
	 * 
	 * TODO: Would be worth working this out in code for practice
	 */
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT; // If using solution in book
	}
}
