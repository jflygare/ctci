package chapter02;

import java.util.ArrayList;
import java.util.List;

import base.BigO;

public class Question04 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write code to partition a linked list around a value x, "
				+ "such that all nodes less than x come before all nodes greater than or equal to x.";
	}

	// This sounds alot like a sort, but only the order in relation to the
	// 'radix' matters
	// Assume the original nodes, just re-ordered. Return the node representing
	// the new head.
	// Assume singly linked list

	public Node partitionFastAnswer(Node node, int x) {
		// Pop nodes off in list and re-build them
		List<Node> headList = new ArrayList<Node>();
		while (node != null) {
			if (node.data >= x) {
				headList.add(node);
			} else {
				headList.add(0, node);
			}
			Node n = node;
			node = n.next;
			n.next = null; // Unlink
		}
		// List is now partitioned. Reconstruct links
		// Iterate to next from last (nothing to link on last element)
		for (int i = 0; i < headList.size() - 1; i++) {
			Node n = headList.get(i);
			Node next = headList.get(i + 1);
			n.next = next;
		}
		// Return head element
		return headList.get(0);
		
		// This runs in O(N) Time and O(N) space
	}

	public Node partition(Node node, int x) {
		// Pop nodes off in list and re-build them
		Node head = node; // Keep track of head node
		Node pop = node.next;
		head.next = null;
		while (pop != null) {
			Node newPop = pop.next;
			pop.next = null; // Unlink
			if (pop.data >= x) {
				// Back
				Node end = head;
				while (end.next != null) {
					end = end.next;
				}
				end.next = pop;
			} else {
				// Front
				pop.next = head;
				head = pop;
			}
			pop = newPop;
		}
		return head;
		
		// This solution is essentially the same as the ones in the book.
		// This runs in O(N) time and O(1) space
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}
}
