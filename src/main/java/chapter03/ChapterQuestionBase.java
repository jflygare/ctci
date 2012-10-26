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

	// Decided to create generic versions of the classes after a few questions
	// in
	public static class Generics {
		public static class Node<T> {
			public T data;
			public Node<T> next;

			public Node(T data) {
				this.data = data;
			}
		}

		// LIFO
		public static class Stack<T> {
			// Keep size in sync with push/pop operations
			// to keep O(1) time complexity. Traversing the nodes
			// would be less error prone and more flexible, but O(n)
			protected int size;
			protected Node<T> top;

			public int size() {
				return size;
			}

			public T pop() {
				if (top != null) {
					T data = top.data;
					top = top.next;
					size--;
					return data;
				}
				return null;
			}

			public void push(T data) {
				Node<T> n = new Node<T>(data);
				n.next = top;
				top = n;
				size++;
			}

			public T peek() {
				return (top == null) ? null : top.data;
			}

			public void log(String msg) {
				System.out.println(msg);
			}
		}

		// FIFO
		public static class queue<T> {
			Node<T> first;
			Node<T> last;

			public void add(T data) {
				if (first == null) {
					last = new Node<T>(data);
					first = last;
				} else {
					last.next = new Node<T>(data);
					last = last.next;
				}
			}

			public T remove() {
				if (first != null) {
					T data = first.data;
					first = first.next;
					return data;
				}
				return null;
			}
		}
	}
}
