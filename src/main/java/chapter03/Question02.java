package chapter03;

public class Question02 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "How would you design a stack which, in addition to push and pop, also has "
				+ "a function 'min' which returns the minimum element? Push, pop and min should all operate in O(1) time";
	}

	/*
	 * In order to keep a constant (O(1)) time complexity, the min value will
	 * have to be stored and kept in sync with pop/push operations
	 */
	// Assume no nulls will be input
	// Assume integer inputs

	public static class MStack extends Stack {

		// Use stack to keep track of current min
		private Stack minStack = new Stack();

		public Integer min() {
			return (Integer) minStack.peek();
		}

		@Override
		public void push(Object data) {
			// Assumption save from type checking
			Integer min = (Integer) data;
			Integer cur = (Integer) minStack.peek();
			if (cur != null && min > cur) {
				min = cur;
			}
			log("Setting min value to " + min);
			minStack.push(min); // Push the min value
			super.push(data);
		}

		@Override
		public Object pop() {
			// pop the min stack to keep in sync
			minStack.pop(); // Throw value away
			return super.pop();
		}
	}

}
