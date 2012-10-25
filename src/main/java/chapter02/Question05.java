package chapter02;

public class Question05 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "You have two numbers represented by a linked list, where each node contains a single digit. "
				+ "The digits are stored in reverse order, such that the 1's digit is a the head of the list. "
				+ "Write a function that adds the two numbers and returns the sum as a linked list. "
				+ "EXAMPLE: Input: (7->1->6) + (5->9->2). That is, 617 + 295. "
				+ "Output: (2->1->9). That is, 912. FOLLOW UP: Suppose the digits are stored in forward order. "
				+ "Repeat the above problem. EXAMPLE: Input: (6->1->7) + (2->9->5), That is, 617 + 295. "
				+ "Output: (9->1->2). That is, 912";
	}

	// Assume singly linked list
	// Assume list can be different sizes
	// Assume positive integers
	// Assume no empty lists

	public Node addReversed(Node n1, Node n2) {
		Node n3 = null;
		// Starting at the 1s place
		int carry = 0;
		// If one of the lists is bigger
		while (n1 != null || n2 != null) {
			int sum = carry;
			if (n1 != null) {
				sum += n1.data;
				n1 = n1.next;
			}
			if (n2 != null) {
				sum += n2.data;
				n2 = n2.next;
			}
			carry = (sum > 9) ? 1 : 0;
			if (n3 == null) {
				n3 = new Node(sum % 10);
			} else {
				n3.appendToTail(sum % 10);
			}
		}
		if (carry > 0) {
			n3.appendToTail(carry);
		}
		return n3;
	}

	public Node add(Node n1, Node n2) {
		// For singly linked list, there does not seem to be a way to add the
		// values in the correct order without either storing values during one
		// loop, or making many recursions. Use string utilities to as a way to
		// store values in single loop
		Node s = null;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while (n1 != null) {
			sb1.append(n1.data);
			n1 = n1.next;
		}
		while (n2 != null) {
			sb2.append(n2.data);
			n2 = n2.next;
		}
		int x1 = Integer.valueOf(sb1.toString());
		int x2 = Integer.valueOf(sb2.toString());
		String sum = String.valueOf(x1 + x2);
		for (char c : sum.toCharArray()) {
			if (s == null) {
				s = new Node(Integer.valueOf(String.valueOf(c)));
			} else {
				s.appendToTail(Integer.valueOf(String.valueOf(c)));
			}
		}
		log(x1 + " + " + x2 + " = " + sum);
		return s;
	}
}
