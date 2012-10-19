package chapter02;

import java.util.ArrayList;
import java.util.List;

public class Question02 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement an algorithm to find the kth to the last element of a singly linked list.";
	}

	// Assuming that the head node is passed in.
	// Assume k = 0 = last node
	// Assume exception for out of bounds index

	// This solution uses List data structure to represent the whole linked list
	// flattened out
	// This can be a very space expensive solution
	public Node endIndexFastAnswer(Node head, int k) {
		List<Node> nodeList = new ArrayList<Node>();
		Node n = head;
		while (n != null) {
			nodeList.add(n);
			n = n.next;
		}
		if (k >= nodeList.size()) {
			throw new IndexOutOfBoundsException();
		}
		return nodeList.get((nodeList.size() - 1) - k);
	}

	// This solution does not use other data structures
	public Node endIndex(Node head, int k) {
		// Get node at index from head
		Node n = head;
		for (int i = 0; i < k; i++) {
			if (n.next == null) {
				throw new IndexOutOfBoundsException();
			}
			n = n.next;
		}
		// Now move both pointers down the line until the n hits the end
		while (n.next != null) {
			n = n.next;
			head = head.next;
		}
		// head pointer should be k from end
		return head;
	}
}
