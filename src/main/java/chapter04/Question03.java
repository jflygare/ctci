package chapter04;

import base.BigO;

public class Question03 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given a sorted (increasing order) array, write an algorithm to create "
				+ "a binary search tree with minimal height.";
	}

	/*
	 * Since the array is already sorted, the hard work is done for us. Just
	 * need to divide and conquer.
	 */

	public static class BinarySearchTree<T> extends BinaryTree<T> {
		
		public BinarySearchTree(T[] sortedArray) {
			setRoot(addSubTreeBook(sortedArray, 0, sortedArray.length -1));
		}

		public BinaryTreeNode<T> addSubTree(T[] array, int startIndex, int endIndex) {
			int size = endIndex - startIndex + 1;
			int midIndex = (size / 2) + startIndex;
			BinaryTreeNode<T> midNode = new BinaryTreeNode<T>(array[midIndex]);
			addNode(midNode);
			if (size > 1)
			{
				midNode.setLeft(addSubTree(array, startIndex, midIndex -1));
			}
			if (size > 2)
			{
				midNode.setRight(addSubTree(array, midIndex +1, endIndex));
			}
			return midNode;
			
			/*
			 * The solution in the book is almost identical to mine, except it is a bit
			 * more optimal in the use of the indexes. Implemented below.
			 */
		}

		public BinaryTreeNode<T> addSubTreeBook(T[] array, int startIndex, int endIndex) {
			if (endIndex < startIndex) {
				return null;
			}
			int midIndex = (startIndex + endIndex) / 2;
			BinaryTreeNode<T> midNode = new BinaryTreeNode<T>(array[midIndex]);
			addNode(midNode);
			midNode.setLeft(addSubTree(array, startIndex, midIndex -1));
			midNode.setRight(addSubTree(array, midIndex + 1, endIndex));
			return midNode;
		}

	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LOGARITHMIC; // Recursive variable instances
		// Still seems odd to me. The only extra memory needed for this is an int per recursion.
		// Is there such thing as an O(1) recursive space complexity?
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LOGARITHMIC; // Divide and conquer
	}

}
