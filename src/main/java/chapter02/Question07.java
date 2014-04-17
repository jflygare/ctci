package chapter02;

import base.BigO;

public class Question07 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement a function to check if a linked list is a palindrome";
	}

	// Assume doubly linked list
	// Assume no circular links

	public boolean isPalindrome(DNode dn) {
		DNode head = dn.first();
		DNode tail = (DNode) dn.last();
		while (head != null) { // Only need to loop tracking one way
			if (head.data != tail.data) {
				return false;
			}
			head = (DNode) head.next;
			tail = tail.prev;
		}
		return true;
		
		// This runs in O(N) time and O(1) space
	}
	
	// The book has a few suggestions for single linked list
	
	// slow/fast runner to find halfway point and keep first
	// half in a stack (O(N) time / O(N) space)
	//
	// The others involve recursive approaches.
	// TODO: Implement these approaches and understand recursion complexity calculations further
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT; // If doubly linked lists are allowed
	}
}
