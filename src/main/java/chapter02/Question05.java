package chapter02;

import java.util.ArrayList;
import java.util.List;

import base.BigO;

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
		
		// EDIT: After coming back to this problem after some time, the solution
		// below (addNoSTrings()) occurred to me pretty easily. Amazing what a little
		// time away from a problem will do....
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
		
		// The BigO for this is hard to calculate due to the utility functions
		// I could not quickly find the time/space complexities for StringBuilder
		// (some suggest O(1), others assume O(n^2)) or *.ValueOf() functions.
		
		// This is not a solution I would recommend demonstrating.
	}

	public Node addNoStrings(Node n1, Node n2) {
		// This solution occured to me after returning to this problem
		// after a great while away from practicing algorithms... Strange.
		
		int x1 = linkedListToInt(n1); //O(N) time O(1) space
		int x2 = linkedListToInt(n2); //O(N) time O(1) space
		
		int sum = x1 + x2;
		log(x1 + " + " + x2 + " = " + sum);
		Node sumNode = intToLinkedList(sum); //O(log n) time/space
		return sumNode;
		
		// This runs in O(N) time and O(log n) space
		
		// The book solution seems considerably more complex than this solution
		// and does not explain why they came up with it. It involves 0 padding
		// the list to make the same size, getting the size of the lists and creating
		// a wrapper class for carrying context through recursive calls. The length calculation
		// alone is O(N) time so the solution cannot be considered more time efficient
	}

	public int linkedListToInt(Node node) {
		// Assume the total number will be an integer
		int num = 0;
		while (node != null) {
			int val = node.data;
			if (num > 0) {
				num *= 10;
			}
			log("Adding " + num + " + " + val);
			num += val;
			node = node.next;
		}
		log("Linklist " + node + " = " + num);
		return num;

		// This runs in O(N) time and O(1) space
	}

	public Node intToLinkedList(int number) {
		log("Creating LinkedList for: " + number);
		// Shortcut if number is less than 10
		if (number < 10) {
			log("Adding node with :" + number);
			return new Node(number);
		}
		List<Integer> numList = new ArrayList<Integer>();
		while (number > 10) {
			numList.add(0, number % 10); // Add to front of array (use stack?)
			number /= 10; // remainder discarded
			// Dividing by 10 each time is logarithmic time
			// Adding to ArrayList is amortized constant time
		}
		// add the final number to array
		numList.add(0, number);
		Node head = null;
		for (Integer num : numList) {
			log("Adding node with :" + num);
			// Do not add leading 0s
			if (head == null && num > 0) {
				head = new Node(num);
			} else {
				head.appendToTail(num);
			}
		}
		log("Created LinkedList: " + head);
		return head;
		
		// This runs in O(log n) time and O(log n) space (since each node is place of 10) 
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LOGARITHMIC;
	}
}
