package chapter03;

import base.BigO;

public class Question06 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write a program to sort a stack in ascending order (with biggest "
				+ "items on top). You may use additional stacks to hold items, but you may not copy "
				+ "the elements into any other data structure (such as an array). "
				+ "The stack supports the following operations: push, pop, peek, and isEmpty";
	}

	/*
	 * This is similar to Hanoi problem. Use 3 stacks for shuffling around.
	 */

	// Could use Comparable interface, but just to keep simple, use stack of
	// ints.
	public void sortStack(Generics.Stack<Integer> stack) {
		if (stack == null | stack.isEmpty()) {
			return;
		}
		int size = stack.size;
		Generics.Stack<Integer> s1 = new Generics.Stack<Integer>();
		Generics.Stack<Integer> s2 = new Generics.Stack<Integer>();
		while (s1.size < size) {
			Integer last = stack.pop();
			// Shuffle s1 -> s2 until we find
			// where last fits in order
			while (!s1.isEmpty() && last > s1.peek()) {
				s2.push(s1.pop());
			}
			// Add to s1
			s1.push(last);
			// Shuffle all s2 back to s1
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		// s1 in assending order
		// shuffle all back to original stack
		// to end up in descending order
		while (!s1.isEmpty()) {
			stack.push(s1.pop());
		}
	}

	/*
	 * AFTER READING THE BOOK, it points out that the 3 stack is not necessary,
	 * and we can use the original stack as a buffer. Clever.
	 */
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}
}
