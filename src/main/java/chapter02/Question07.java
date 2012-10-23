package chapter02;

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
	}
}
