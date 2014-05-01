package chapter04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import base.BigO;
import chapter04.ChapterQuestionBase.BinaryTree.BinaryTreeNode;

public class Question08 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "You have two very large binary trees: T1, with millions of nodes, "
				+ "and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1."
				+ "A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree "
				+ "n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.";
	}

	/*
	 * Assumptions: We know which tree is larger May or may not be a binary
	 * search tree May or may not be balanced The exact size of each tree is not
	 * known
	 * 
	 * If we know the sizes, we could determine which level to begin on in a
	 * level-order search.
	 * 
	 * 
	 * Traverse the larger tree looking for the root of the smaller (Level-order
	 * search seems optimal). When smaller tree is found, traverse both
	 * simultaneously (order does not matter), comparing each node at each step.
	 * If nodes do not match, bail fast.
	 */

	public boolean isSubtree(BinaryTreeNode<?> largeRoot,
			BinaryTreeNode<?> smallRoot) {
		// Assume null not expected
		BinaryTreeNode<?> subRoot = findSubRoot(largeRoot, smallRoot);
		if (subRoot == null) {
			return false; // common node not found
		}

		// Traverse each tree in same order, comparing each node.
		// does not matter which order.
		// Use stack for earlier comparison failure
		Stack<BinaryTreeNode<?>> stack1 = new Stack<BinaryTreeNode<?>>();
		Stack<BinaryTreeNode<?>> stack2 = new Stack<BinaryTreeNode<?>>();

		stack1.push(subRoot);
		stack2.push(smallRoot);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (stack1.isEmpty() != stack2.isEmpty()) {
				return false;
			}
			BinaryTreeNode<?> node1 = stack1.pop();
			BinaryTreeNode<?> node2 = stack2.pop();
			if (!node1.getDatum().equals(node2.getDatum())) {
				return false; // Node mismatch
			}
			if (node1.getLeft() != null) {
				stack1.push(node1.getLeft());
			}
			if (node2.getLeft() != null) {
				stack2.push(node2.getLeft());
			}
			if (node1.getRight() != null) {
				stack1.push(node1.getRight());
			}
			if (node2.getRight() != null) {
				stack2.push(node2.getRight());
			}
		}

		return true; // Traversed both trees
		// O(N) Space / O(N) time
	}

	protected BinaryTreeNode<?> findSubRoot(
			BinaryTreeNode<?> largeRoot, BinaryTreeNode<?> smallRoot) {
		// Assume null is not expected
		Queue<BinaryTreeNode<?>> queue = new LinkedList<BinaryTreeNode<?>>();
		queue.add(largeRoot);
		while (!queue.isEmpty()) {
			BinaryTreeNode<?> node = queue.poll();
			if (node.getDatum().equals(smallRoot.getDatum())) {
				System.out.println("Subroot found at node: " + node.getDatum());
				return node; // Found root of sub tree
			}
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		return null; // Not found
		// O(N) Space / O(N) time
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}

}
