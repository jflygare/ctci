package chapter04;

import java.util.HashSet;
import java.util.Set;

import base.BigO;
import chapter04.Question06.NextSuccessorTree;

public class Question07 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Design an algorithm and write code to find the first common ancestor of two nodes "
				+ "in a binary search tree. Avoid storing additional nodes in a data structure.\n"
				+ "NOTE: This is not necessarily a binary search tree.";
	}

	/*
	 * If the nodes do not have links to their parents, than the space
	 * complexity of traversing from root to find and store predecessor info is
	 * considerable. O(N) time - O(N^2) space.
	 * 
	 * By using nodes that have links to the parent, we can create a list of
	 * ancestors for each node by reverse traversing. Then compare the lists for
	 * an intersection. If the tree is unbalanced, this would be O(N) time
	 * (worst case) and O(N) space. If the tree is balanced, it would run in
	 * O(log N) time, as the depth of the search increases once every doubling
	 * of the leaf nodes.
	 * 
	 * Taking this further.. we only need to keep track of one ancestry, and
	 * compare during the traversal of the second node. If we use a hash
	 * structure, the average time for random search averages to O(1).
	 * 
	 * Without keeping track of the parent nodes, and using nodes that have
	 * links to the parent, we can start at the target nodes and do a reverse
	 * traversal up from one node.For each traversal from the node, the other
	 * node does a full reverse traversal up to the top, comparing parentage at
	 * each traversal. Even though a full tree traversal is not necessary, the
	 * time complexity is still O(N^2) due to the nested looping. In worst case,
	 * nodes are at farthest opposite sides and tree is very unbalanced, skewing
	 * hardest on both sides. This runs in O(N^2) time but can be made to run in
	 * O(1) space (using iteration instead of recursion).
	 * 
	 * More information would help decide a strategy. Is it binary search tree?
	 * Does the node know its level? What values do the nodes represent (to
	 * determine possible skewing).
	 * 
	 * Given the tradoffs... I am going to go with my second approach. Create 2
	 * lists of ancestry and compare.
	 */

	// Using tree from question 6 for convenience
	public static class CommonAncestorBinaryTree extends NextSuccessorTree {

		public CommonAncestorBinaryTree(Integer[] sortedArray) {
			super(sortedArray);
		}

		public Integer commonAncestor(Integer value1, Integer value2) {
			// TODO: Validate input
			// No justification for recursive function
			// Use HashSet for O(1) lookup
			// Store value instead of node since we are not overloading
			// hashcode/equal.
			Set<Integer> ancestorSet1 = new HashSet<Integer>();
			LinkedBinaryTreeNode<Integer> node1 = getNode(value1);
			while (node1 != null) {
				ancestorSet1.add(node1.getDatum());
				node1 = node1.getParent();
			}

			LinkedBinaryTreeNode<Integer> node2 = getNode(value2);
			while (node2 != null) {
				if (ancestorSet1.contains(node2.getDatum())) {
					Integer ancestor = node2.getDatum();
					System.out.println("Ancestor of " + value1 + " and "
							+ value2 + " = " + ancestor);
					return ancestor;
				}
				node2 = node2.getParent();
			}
			return null; // No ancestor found
		}
	}
	
	/*
	 * The book also picks up on the different criteria options (that I mentioned above)
	 * but decides to solve recursively without storing results in a data structure
	 * or reverse traversing through the parentage.
	 * 
	 * The basic strategy is to split the tree at each level and determine if both nodes
	 * are found either to the right, the left or on both sides. Recursing until the nodes
	 * wind up on both sides of the node, making that node the ancestor. It also offers a solution
	 * for handling the case where the target node is not in the tree (odd case).
	 * 
	 * The solution is pretty complex, but does still offer O(N) runtime and O(N) space.
	 */

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Would be O(log N) if tree were balanced
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; // Would be O(log N) if tree were balanced
	}

}
