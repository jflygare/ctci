package chapter04;

import java.util.LinkedList;
import java.util.List;

import base.BigO;
import chapter04.Question06.NextSuccessorTree;

public class Question09 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "You are given a binary tree in which each node contains a value."
				+ "Design an algorithm to print all paths which sum to a given value. Note that "
				+ "a path can start or end anywhere in the tree";
	}

	/*
	 * Assumptions: Values are integers Values are not necessarily unique Tree
	 * is not necessarily balanced Tree is not necessarily BST
	 * 
	 * initial (brute force?) thought.. start any traversal. For each node
	 * traversal, Start a new pre-order traversal, carrying a running sum and
	 * node history (an array copy through each recursion). At each node,
	 * compare running sum. if sum is equal, return node history. On left
	 * condition if history found, add to running list of found arrays. continue
	 * recurse on right with current array. continue primary recursion.
	 * 
	 * ... This seems like it can be reduced to a single recursive function
	 * which would decrease time complexity from O(n^2) to O(N). In either case
	 * Space complexity is O(n^2) as each node in tree could have create and add
	 * to copies of each recursion arrays.
	 * 
	 * ... Realized during implementing that there is no need for the recursive
	 * function to return anything. The base conditions are handled and the
	 * paths are accumulated in the map that is passed through the recursion.
	 */

	// Using Tree from question 6 for convenience... Just to take advantage
	// of the balanced tree creation from a list... the unit test will
	// use a random number generator and node values may not be unique,
	// so we cannot rely on the getNode() function...
	public static class SumPathBinaryTree extends NextSuccessorTree {

		public SumPathBinaryTree(Integer[] sortedArray) {
			super(sortedArray);
		}

		public List<List<BinaryTreeNode<Integer>>> sumPaths(int sum) {
			List<List<BinaryTreeNode<Integer>>> foundPaths = new LinkedList<List<BinaryTreeNode<Integer>>>();
			findSumPaths(getRoot(), new NodeSum(sum), foundPaths);
			return foundPaths;

		}

		protected void findSumPaths(BinaryTreeNode<Integer> node, NodeSum sum,
				List<List<BinaryTreeNode<Integer>>> foundPaths) {
			if (node == null) {
				return;
			}
			// pre-order traversal

			// SELF
			if (sum.addNode(node)) {
				if (sum.isSumPath()) {
					foundPaths.add(sum.nodeList);
					// this recursion path complete
				} else {
					// can continue recursion
					// LEFT (current recursion)
					findSumPaths(node.getLeft(), sum.copy(), foundPaths);
					// RIGHT (current recursion)
					findSumPaths(node.getRight(), sum.copy(), foundPaths);
				}
			} // Else node exceeded running sum limit
				// Regardless of whether the current running recursion is
				// complete,
				// start a new recursion on the child nodes of this node.

			// LEFT (new recursion)
			findSumPaths(node.getLeft(), new NodeSum(sum.targetSum), foundPaths);
			// RIGHT (new recursion)
			findSumPaths(node.getRight(), new NodeSum(sum.targetSum),
					foundPaths);
		}

		public static class NodeSum {
			int targetSum;
			int sum;
			// Using linked list to reduce memory usage per copy
			List<BinaryTreeNode<Integer>> nodeList = new LinkedList<BinaryTreeNode<Integer>>();

			public NodeSum(int targetSum) {
				this.targetSum = targetSum;
			}

			public boolean addNode(BinaryTreeNode<Integer> node) {
				if (node.getDatum() + sum <= targetSum) {
					nodeList.add(node);
					sum += node.getDatum();
					return true;
				}
				return false; // Adding would put us over limit
			}

			public boolean isSumPath() {
				return targetSum == sum;
			}

			// Need to make a copy so that the left and right
			// paths can be handled independently
			public NodeSum copy() {
				// Assume that if this does not operate in O(N) time and
				// O(N) space
				// that we can implement a solution that does.
				NodeSum copy = new NodeSum(this.targetSum);
				copy.sum = this.sum;
				copy.nodeList = new LinkedList<BinaryTreeNode<Integer>>(this.nodeList);
				return copy;
			}
		}
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Would be exponential if not using LinkedList
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.EXPONENTIAL; // Or perhaps linearithmic?
	}

}
