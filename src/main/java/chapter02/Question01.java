package chapter02;

import base.BigO;

public class Question01 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write code to remove duplicates from an unsorted linked list. "
				+ "FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed";
	}

	/*
	 * I assume 'no temp buffer' does not mean we cannot use pointers as
	 * temporary reference holders.
	 */

	public void removeDuplicates(Node head) {
		Node n = head;
		while (n != null) {
			deleteNodesWithData(n, n.data);
			n = n.next;
		}
	}

	public void deleteNodesWithData(Node node, int data) {
		Node n = node.next;
		if (n == null) {
			return;
		}
		// Next node has same data
		if (n.data == data) {
			// Re-link to node after next
			node.next = n.next;
			// Do again with same start node
			deleteNodesWithData(node, data);
		} else {
			// Recurse using next node as start
			deleteNodesWithData(n, data);
		}
	}

	// https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter%202/Question2_1/Question.java
	/*
	 * AFTER READING BOOK ANSWER: By "temp buffer" they meant hash table (or the
	 * like) to keep track of visited data values. Though, in the example they give,
	 * a Hashtable is used when a simple set would suffice.
	 * If a temp buffer is used, the algorithm runs in O(N) time and O(1) space
	 * 
	 * Also, the book suggests using a "runner" pointer instead of my recursive
	 * function. I did not consider looking 2 nodes ahead (node.next.next) and
	 * re-linking it to node.next, but that works fine even if null.
	 * Both mine and the book runs in O(n^2) time and O(1) space
	 */
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.QUADRADIC;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}
}
