package chapter04;

import base.BigO;

public class Question05 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement a function to check if a binary tree is a binary search tree";
	}

	// Just make Integer for simplicity. Can do tricks with comparators, etc...
	public static class BinarySearchTree extends chapter04.Question03.BinarySearchTree<Integer> {

		public BinarySearchTree(Integer[] sortedArray) {
			super(sortedArray);
		}

		public boolean isBST() {
			return isBST(root);
		}

		protected boolean isBST(BinaryTreeNode<Integer> node) {
			// Assume unique key

			// post-order LRS
			// LEFT
			if (node.getLeft() != null
					&& node.getLeft().getDatum() > node.getDatum()) {
				return false;
			}
			// RIGHT
			if (node.getRight() != null
					&& node.getRight().getDatum() < node.getDatum()) {
				return false;
			}

			// SELF
			if (node.getLeft() != null && !isBST(node.getLeft())) {
				return false;
			}
			if (node.getRight() != null && !isBST(node.getRight())) {
				return false;
			}
			return true; // full recursion

		}
	}
	
	/*
	 * The book offers two solutions, each keeping track of visited data outside the recursive function.
	 * It seems my way is more efficient than either of the suggested solutions, as mine requires no
	 * extra memory.
	 */

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; // Still must visit all nodes in worst case
	}

}
