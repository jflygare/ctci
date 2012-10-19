package chapter02;

import base.QuestionBase;

public abstract class ChapterQuestionBase extends QuestionBase {
	@Override
	public String answersUrl() {
		return "https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter+2";
	}

	public static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}

		Node appendToTail(int data) {
			Node end = new Node(data);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
			return end;
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
}
