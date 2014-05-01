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
			return isBST(root, new IntWrapper());
		}

		@Deprecated
		protected boolean _isBST(BinaryTreeNode<Integer> node) {
			// Assume unique key

			// in-order (kind of)
			// LEFT
			if (node.getLeft() != null &&
					(!_isBST(node.getLeft()) ||
					node.getLeft().getDatum() > node.getDatum())) {
				return false;
			}
			// RIGHT
			if (node.getRight() != null &&
					(!_isBST(node.getRight()) ||
					node.getRight().getDatum() < node.getDatum())) {
				return false;
			}
			return true; // full recursion
		}
		
		/*
		 * After reading the solution in the book, I realized that my solution does not
		 * account for the condition that all nodes to the left must be less then the current node
		 * and all nodes to the right must be greater... My solution would pass given the invalid
		 * tree:
		 * 
		 *    20
		 *   /  \
		 *  10  30
		 *   \
		 *    25
		 * 
		 */
		
		protected boolean isBST(BinaryTreeNode<Integer> node, IntWrapper last) {
			if (node == null) {
				return true;
			}
			
			//Left
			if (!isBST(node.getLeft(), last)) {
				return false;
			}
			
			//Self
			if (node.getDatum() < last.value) {
				return false;
			}
			last.value = node.getDatum();
			
			//Right
			if (!isBST(node.getRight(), last)) {
				return false;
			}
			
			return true; //Full recursion
		}
		
		public static class IntWrapper {
			public int value = Integer.MIN_VALUE;
		}
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; // Still must visit all nodes in worst case
	}

}
