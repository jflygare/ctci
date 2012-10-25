package chapter03;

import base.QuestionBase;

public abstract class ChapterQuestionBase extends QuestionBase {
	@Override
	public String answersUrl() {
		return "https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter+3";
	}

	public static class Node {
		public Object data;
		public Node next;

		public Node(Object data) {
			this.data = data;
		}
	}

	// LIFO
	public static class Stack {
		private Node top;

		public Object pop() {
			if (top != null) {
				Object data = top.data;
				top = top.next;
				return data;
			}
			return null;
		}

		public void push(Object data) {
			Node n = new Node(data);
			n.next = top;
			top = n;
		}

		public Object peek() {
			// NOTE: This code follows example in book, but book version does
			// not check for nulls
			// obvious mistake for a book preaching about getting your answers
			// right
			return (top == null) ? null : top.data;
		}

		public void log(String msg) {
			System.out.println(msg);
		}
	}

	// FIFO
	public static class queue {
		Node first;
		Node last;

		public void add(Object data) {
			if (first == null) {
				last = new Node(data);
				first = last;
			} else {
				last.next = new Node(data);
				last = last.next;
			}
		}

		// NOTE: This code follows example in book, but book code has return
		// type of Node
		// which is an obvious mistake for a book preaching about getting your
		// answers right
		public Object remove() {
			if (first != null) {
				Object data = first.data;
				first = first.next;
				return data;
			}
			return null;
		}
	}
}
