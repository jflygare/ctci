package chapter02;

import java.util.HashSet;
import java.util.Set;

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
		Set<Node> nodeSet = new HashSet<Node>();
		while (n1 != null) {
			log("Visited node: " + (char) n1.data);
			if (nodeSet.contains(n1)) {
				log("Circular node = " + (char) n1.data);
				return n1;
			} else {
				nodeSet.add(n1);
				n1 = n1.next;
			}
		}
		// No recursive nodes found
		return null;
	}
}
