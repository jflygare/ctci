package chapter03;


public class Question05 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement a MyQueue class which implements a queue using two stacks";
	}

	/*
	 * Assuming we only have pop/push|enqueue/unqueue as interfaces. Access to
	 * lower level nodes could provide more optimal algorithm. Dont think that
	 * is the point of this exercise.
	 */

	public static class MyQueue<T> {
		private Generics.Stack<T> s1 = new Generics.Stack<T>();
		private Generics.Stack<T> s2 = new Generics.Stack<T>();

		public void enqueue(T data) {
			// Shuffle all to stack 2 (will be reversed)
			T last = null;
			while ((last = s1.pop()) != null) {
				s2.push(last);
			}
			// Add to stack 1 and shuffle back
			s1.push(data);
			while ((last = s2.pop()) != null) {
				s1.push(last);
			}
		}

		public T unqueue() {
			// Just pop from stack 1.
			// Should be in reverse order from which elements were added
			return s1.pop();
		}
	}
}
