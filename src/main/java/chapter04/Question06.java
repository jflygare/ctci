package chapter04;

import java.util.HashMap;
import java.util.Map;

import base.BigO;

public class Question06 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write an algorithm to find the 'next' node (i.e. in-order successor) "
				+ "of a given node in a binary search tree. You may assume that each node "
				+ "has a link to its parent";
	}

	/*
	 * NOTE: A "threaded" binary tree keeps track of this relationship.
	 * 
	 * In-order successor = the next node recursively visited to the right. or
	 * node with the smallest key greater than the input key
	 * 
	 * Not sure why we need extra conditions if we can do just one pass, left
	 * hand traversal on the input node's right subtree... .... DUH! After
	 * implementing this, I realized this does not work for leaf nodes... which
	 * is why we would could use a reference to the parent.. arg!
	 * 
	 * 
	 * One way could be to perform an in-order traversal starting from root,
	 * comparing each visited node with the input node. When reached, perform
	 * one more traversal to get the successor. This would run in O(N) time and
	 * O(N) space.
	 * 
	 * But since we are able to traverse in reverse...
	 * 
	 * if node has no right, it does not own its successor compare to parent
	 * key. If parent > self, parent is successor else recurse to its parent. if
	 * no node found, input is end node (has no successor) if node has right,
	 * do left only traversal on right node
	 * 
	 * This took me a great deal of time to work out (avoiding try/debug).
	 * It started to get pretty complex and I was sure the book was going to
	 * recommend a simpler solution. But it turns out my solution is pretty close
	 * to that in the book. They did it without recursion and minimal code.
	 * 
	 */

	/**
	 * The Class NextSuccessorTree.
	 * 
	 * Loading from sorted array taken from Question03 solution for convenience.
	 * 
	 * @param <T>
	 *            the generic type
	 */
	public static class NextSuccessorTree extends BinaryTree<Integer> {

		private Map<Integer, LinkedBinaryTreeNode<Integer>> nodeMap = new HashMap<Integer, LinkedBinaryTreeNode<Integer>>();

		public NextSuccessorTree(Integer[] sortedArray) {
			root = addSubTree(sortedArray, 0, sortedArray.length - 1, null);
			nodeMap.put(root.getDatum(), (LinkedBinaryTreeNode<Integer>) root);
		}
		
		protected LinkedBinaryTreeNode<Integer> getNode(Integer value) {
			return nodeMap.get(value);
		}

		public LinkedBinaryTreeNode<Integer> addSubTree(Integer[] array,
				int startIndex, int endIndex,
				LinkedBinaryTreeNode<Integer> parent) {
			if (endIndex < startIndex) {
				return null;
			}
			int midIndex = (startIndex + endIndex) / 2;
			LinkedBinaryTreeNode<Integer> midNode = new LinkedBinaryTreeNode<Integer>(
					array[midIndex]);
			if (parent != null) {
				midNode.setParent(parent);
			}
			nodeMap.put(midNode.getDatum(), midNode);
			midNode.setLeft(addSubTree(array, startIndex, midIndex - 1, midNode));
			midNode.setRight(addSubTree(array, midIndex + 1, endIndex, midNode));
			return midNode;
		}

		@Override
		public LinkedBinaryTreeNode<Integer> getRoot() {
			return (LinkedBinaryTreeNode<Integer>) super.getRoot();
		}

		// @Override
		public void setRoot(LinkedBinaryTreeNode<Integer> root) {
			super.setRoot(root);
		}

		public Integer getNext(Integer key) {
			System.out.println("Looking for successor to: " + key);
			LinkedBinaryTreeNode<Integer> node = nodeMap.get(key);
			if (node == null) {
				return null;
			}
			LinkedBinaryTreeNode<Integer> next = nextSuccssor(node);
			if (next == null) {
				return null;
			}
			//System.out.println("Successor of " + key + " = " + next);
			return next.getDatum();
		}

		@Deprecated
		// Does not work for leaf nodes
		public Integer _getNext(Integer key) {
			BinaryTreeNode<Integer> node = nodeMap.get(key);
			if (node == null) {
				return null;
			}
			BinaryTreeNode<Integer> next = _nextLeft(node.getRight());
			if (next == null) {
				return null;
			}
			Integer d = next.getDatum();
			System.out.println("Successor of " + key + " = " + d);
			return d;
		}

		@Deprecated
		// Does not work for leaf nodes
		protected BinaryTreeNode<Integer> _nextLeft(BinaryTreeNode<Integer> node) {
			if (node == null) {
				return null;
			}
			BinaryTreeNode<Integer> next = _nextLeft(node.getLeft());
			if (next == null) {
				return node;
			}
			return next;
		}

		protected LinkedBinaryTreeNode<Integer> nextSuccssor(
				LinkedBinaryTreeNode<Integer> node) {
			if (node == null) {
				return null;
			}
			LinkedBinaryTreeNode<Integer> next = null;
			if (node.getRight() == null) {
				// Must look upstream for successor
				next = upstreamSuccessor(node);
				if (next != null) {
					System.out.println(node + " successor " + next
							+ " found upstream");
					return next; // Found successor
				}
				// Otherwise there are no successors
				return null;
			} else {
				// successor can be found in right sub tree. Do left side
				// traversal to the right node.
				next = downStreamSuccessor(node.getRight());
				if (next == null) {
					// Otherwise the right node is the successor
					next = node.getRight();
				}
				System.out.println(node + " successor " + next
						+ " found downstream");
				return next;
			}
		}

		protected LinkedBinaryTreeNode<Integer> upstreamSuccessor(
				LinkedBinaryTreeNode<Integer> node) {
			if (node == null || node.getParent() == null) {
				return null;
			}
			if (node.getDatum() < node.getParent().getDatum()) {
				return node.getParent(); // Successor found
			}
			return upstreamSuccessor(node.getParent()); // Recurse.
		}

		protected LinkedBinaryTreeNode<Integer> downStreamSuccessor(
				LinkedBinaryTreeNode<Integer> node) {
			if (node == null) {
				return null;
			}
			// Stay Left
			LinkedBinaryTreeNode<Integer> next = downStreamSuccessor(node
					.getLeft());
			if (next == null) {
				// this is the last left node
				next = node;
			}
			return next; // downstream successor found
		}

		public static class LinkedBinaryTreeNode<T> extends BinaryTreeNode<T> {

			private LinkedBinaryTreeNode<T> parent;

			public LinkedBinaryTreeNode<T> getParent() {
				return parent;
			}

			public void setParent(LinkedBinaryTreeNode<T> parent) {
				this.parent = parent;
			}

			public LinkedBinaryTreeNode() {
			}

			public LinkedBinaryTreeNode(T datum) {
				super(datum);
			}

			@Override
			public LinkedBinaryTreeNode<T> getLeft() {
				return (LinkedBinaryTreeNode<T>) super.getLeft();
			}

			// @Override
			public void setLeft(LinkedBinaryTreeNode<T> left) {
				super.setLeft(left);
			}

			@Override
			public LinkedBinaryTreeNode<T> getRight() {
				return (LinkedBinaryTreeNode<T>) super.getRight();
			}

			// @Override
			public void setRight(LinkedBinaryTreeNode<T> right) {
				super.setRight(right);
			}

			@Override
			public String toString() {
				return "[" + getDatum() + "]";
			}

		}
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; // Travel all nodes in worst case
	}

}
