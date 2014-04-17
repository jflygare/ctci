package chapter02;

import base.BigO;

public class Question03 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement an algorithm to delete a node in the middle of a singly linked list, "
				+ "given only access to that node. EXAMPLE: Input: the node c from the linked list a->b->c->d->e. "
				+ "Result: nothing is returned, but the new linked list looks like a->b->d->e";
	}

	// Assume that only the data is what matters, and not the reference to the
	// original pointers
	// Assume that input node will never be the end node

	public void deleteNode(Node node) {
		if (node.next == null) {
			throw new RuntimeException("Cannot delete from end of list");
		}
		Node last = node;
		while (node.next != null) {
			// Move data from next into this
			node.data = node.next.data;
			last = node;
			node = node.next; // Move pointer
		}
		// Remove link from last changed node
		last.next = null;
	}

	/*
	 * AFTER READING THE BOOK I realize that it is un-necessary to traverse the
	 * whole rest of the list. Simply copy the data and link of the next node
	 * and then delete it.
	 * 
	 * My solution runs in O(N) time and O(1) space 
	 */
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.CONSTANT; //If used solution in book
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}
}
