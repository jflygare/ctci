package chapter02;

import base.QuestionBase;

public abstract class ChapterQuestionBase extends QuestionBase {
	@Override
	public String answersUrl() {
		return "https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter+2";
	}

	public static class Node {
		public Node next;
		public int data;

		public Node(int data) {
			this.data = data;
		}

		public Node appendToTail(int data) {
			Node end = new Node(data);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
			return end;
		}

		public Node last() {
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			return n;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[" + data + "]");
			if (next != null) {
				sb.append(next.toString());
			}
			return sb.toString();
		}

		public String toCharString() {
			StringBuilder sb = new StringBuilder("[" + (char) data + "]");
			if (next != null) {
				sb.append(next.toCharString());
			}
			return sb.toString();
		}

	}

	public static class DNode extends Node {

		public DNode prev;

		public DNode(int data) {
			super(data);
		}

		public DNode first() {
			DNode n = this;
			while (n.prev != null) {
				n = n.prev;
			}
			return n;
		}

		@Override
		public Node appendToTail(int data) {
			DNode end = new DNode(data);
			DNode n = this;
			while (n.next != null) {
				n = (DNode) n.next;
			}
			n.next = end;
			end.prev = n;
			return end;
		}

	}
}
