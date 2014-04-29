package chapter04;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import base.BigO;

public class Question04 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given a binary tree, design an algorithm which creates a linked "
				+ "list of all the nodes at each depth (e.g., if you have a tree "
				+ "with depth D, you'll have D linked lists)";
	}

	/*
	 * This calls for level-order traversal. Use a queue...
	 */

	public static class LinkedListBinaryTree<T> extends BinaryTree<T> {

		public Map<Integer, LinkedList<BinaryTreeNode<T>>> getLevelLists() {
			Map<Integer, LinkedList<BinaryTreeNode<T>>> depthMap =
					new HashMap<Integer, LinkedList<BinaryTreeNode<T>>>();
			fillDepthMap(root, 0, depthMap);
			return depthMap;
		}

		private void fillDepthMap(BinaryTreeNode<T> node, int depth,
				Map<Integer, LinkedList<BinaryTreeNode<T>>> depthMap) {
			if (node == null) {
				return; // leaf
			}
			LinkedList<BinaryTreeNode<T>> depthList = depthMap.get(depth);
			if (depthList == null) {
				depthList = new LinkedList<BinaryTreeNode<T>>();
				depthMap.put(depth, depthList);
			}
			System.out.println("Adding node: " + node + " to level list "
					+ depth);
			depthList.add(node);
			fillDepthMap(node.getLeft(), depth + 1, depthMap);
			fillDepthMap(node.getRight(), depth + 1, depthMap);
		}
		/*
		 * This solution is almost identical to the first solution in the book
		 * (with the exception of using a List of lists instead of a map of lists).
		 * The book also suggests a non-recursive approach, which does use less memory,
		 * but is equally BigO efficient as the above solution.
		 * 
		 * TODO: The explanation in the solution talks more about calculating space complexity.
		 * Revisit this for more understanding.
		 */
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; //Or can this be considered logarithmic?
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; //Have to traverse all nodes
	}

}
