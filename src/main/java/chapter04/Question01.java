package chapter04;

import base.BigO;

public class Question01 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement a function to check if a binary tree is balanced. "
				+ "For the purposes of this question, a balanced tree is defined to be a tree such "
				+ "that the heights of the two subtrees of any node never differ by more than one";
	}

	/*
	 * Since we want to get to the leaf nodes as quick as possible, it seems a
	 * post order traversal would be the way to go.
	 * 
	 * If we stored more information in during the add/remove operations (like
	 * size, level, height...) we could reduce the time complexity to O(1)
	 */

	public static class BalanceTestBinaryTree<T> extends BinaryTree<T> {

		public boolean isBalanced() {

			// Start recursive call on root
			if (isBalanced(root)) {
				System.out.println("Tree is balanced");
				return true;
			} else {
				return false;
			}
		}

		/*
		 * Perform a post-order traversal, looking for nodes with only
		 * the left or right child missing. Then test the height of the other
		 * child. This still runs in O(N) time, but only worst case.
		 */
		protected boolean isBalanced(BinaryTreeNode<T> node) {
			// Base conditions
			if (node == null || node.isLeaf()) {
				return true; // Empty or leaf
			}
			// Post-order traversal (LRS)
			// L(eft)
			if (!isBalanced(node.getLeft())) {
				return false; // Return quick
			}
			// R(ight)
			if (!isBalanced(node.getRight())) {
				return false; // Return quick;
			}
			// S(elf)
			if (node.getLeft() == null || node.getRight() == null) {
				// We are at a node with a potential unbalance
				int h = 0;
				if (node.getLeft() != null) {
					// We know only the left exits. Test height
					h = getHeight(node.getLeft());
				} else {
					// We know that only right exists. Test height
					h = getHeight(node.getRight());
				}
				if (h > 1) {
					System.out.println("Unbalance found in node: " + node);
					return false;
				} else {
					return true;
				}
			} else {
				// Node has both left and right and the recursive calls above
				// were balanced, so we can assume this node is balanced
				return true;
			}
		}

		public int getHeight(BinaryTreeNode<T> node) {
			if (node == null) {
				return 0; // Leaf
			}
			int rh = getHeight(node.getRight()) + 1;
			int lh = getHeight(node.getLeft()) + 1;
			int h = Math.max(rh, lh);
			System.out.println("Height of node: " + node + " = " + h);
			return h;
			// Runs in O(N) time, O(N) space (for recursive stack vars)
		}
	}

	
	/*
	 * The book solution points out that the recursive methods to getHeight and test for balance can
	 * be combined into one method. This is done by testing the current node for balance as soon as the height
	 * of the left and right are found. Return a -1 to indicate an unbalance and shortcut the recursion
	 * if found.
	 * 
	 * NOTE: The book suggests this solution has O(log N) space complexity. But I am not sure
	 * why, since the methods are recursive and all nodes must be visited in worst case. Each
	 * recursion has variables.
	 */
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; //? Book says their solution is LOGARITHMIC
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}

}
