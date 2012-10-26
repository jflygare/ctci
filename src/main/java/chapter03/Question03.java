package chapter03;

import java.util.ArrayList;
import java.util.List;

public class Question03 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Imagine a (literal) stack of plates. If the stack gets too high, it might topple. "
				+ "Therefore, in real live, we would likely start a new stack when the previous stack exceeds "
				+ "some threshold. Implement a data structure 'SetOfStacks' that mimics this. "
				+ "'SetOfStacks' should be composed of several stacks and should create a new stack once "
				+ "the previous one exceeds capacity. 'SetOfStacks.push(); and 'SetOfStacks.pop()' "
				+ "should behave identically to a single stack (that is, pop() should return the same values "
				+ "as it would if they were just a single stack). FOLLOW UP: Implement a function "
				+ "'popAt(int index) which performs a pop operation on a specific sub-stack";
	}

	/*
	 * I decided to create generics versions of the Node/Stack/Queue classes (so
	 * I dont have to keep casting) I first thought of creating a 'stack of
	 * stacks', but need random access to the stacks, which a stack does not
	 * provide. I then thought of creating a stack with 2 top nodes. A node of
	 * data, and a node of nodes. This allowed me to traverse the nodes in a way
	 * that resembles random access, and requires no additional space, but
	 * realized I was just trying to be too cleaver and made it more complicated
	 * than it should be. It helped to think about the stack of plates (like at
	 * a buffet) analogy. As new plates come in from the kitchen, they are
	 * stacked at the end. People are free to choose either the newest plate
	 * (pop) or take a plate from any other stack (popAt)
	 * 
	 * I think the problem would have been more intuitive by adding the
	 * requirement that push attempts to keep the stacks as even as possible.
	 */

	public static class SetOfStacks<T> extends Generics.Stack<T> {

		private int limit = 10;
		private List<Generics.Stack<T>> stackList = new ArrayList<Generics.Stack<T>>();

		public SetOfStacks() {
		}

		public SetOfStacks(int limit) {
			this.limit = limit;
		}

		/*
		 * What should size represent? Number of stacks? Number of elements?
		 * Size of current stack? This is one reason this question is so
		 * strange. Mix of concepts. I am going to go with size of current
		 * stack, since it seems to fit best with the stacks of plates analogy.
		 * No need to override size()
		 */

		/*
		 * Equivalent to adding plate to last (current) stack, or starting new
		 * stack of plates
		 */
		@Override
		public void push(T data) {
			if (size == limit) {
				// Move current stack to list
				Generics.Stack<T> stack = new Generics.Stack<T>();
				stack.top = this.top;
				stack.size = this.size;
				stackList.add(stack);
				// Reset current stack
				this.top = null;
				this.size = 0;
			}
			super.push(data);
		}

		/*
		 * Equivalent to taking top plate of last (current) stack
		 */
		@Override
		public T pop() {
			if (size == 1 && !stackList.isEmpty()) {
				// Last item in current stack. More stacks available
				T data = super.pop();
				Generics.Stack<T> stack = stackList
						.remove(stackList.size() - 1);
				this.top = stack.top;
				this.size = stack.size;
				return data; // Return last item in what was the current
								// stack
			}
			return super.pop(); // More in current stack or completely empty
		}

		@Deprecated
		// Name misleading. I first thought the purpose was to remove the nth
		// item from the complete set of items. This would have worked very
		// differently.
		public T popAt(int index) {
			return popFromStack(index);
		}

		/*
		 * Equivalent to taking plate off some stack in middle
		 */
		public T popFromStack(int index) {
			// 0 = current stack
			if (index > stackList.size() || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			if (index == 0) {
				return pop();
			}
			// Popping from other stack
			int i = index + 1;
			Generics.Stack<T> stack = stackList.get(i);
			// If last item in that stack, remove from list
			if (stack.size == 1) {
				stackList.remove(i);
			}
			return stack.pop();
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append("|");
			}
			for (int i = 0; i < stackList.size(); i++) {
				sb.append('\n');
				for (int j = 0; j < stackList.get(i).size; j++) {
					sb.append("|");
				}
			}
			return sb.toString();
		}
	}

}
