package chapter04;

import java.util.LinkedList;
import java.util.Queue;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;
import chapter04.ChapterQuestionBase.BinaryTree.BinaryTreeNode;
import chapter04.Question01.BalanceTestBinaryTree;

public class Question01Test extends QuestionTestBase<Question01> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question01());
	}
	
	private BalanceTestBinaryTree<Integer> getBinaryTree(boolean isBalanced) {
		int MAX_NODES = 16 - 1; //Base 2 number - 1
		BalanceTestBinaryTree<Integer> tree = new BalanceTestBinaryTree<Integer>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		for (int i = 1; i < MAX_NODES;) {
			BinaryTreeNode<Integer> node = queue.poll();
			BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(++i);
			BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(++i);
			queue.add(left);
			queue.add(right);
			node.setLeft(left);
			node.setRight(right);
			if (!isBalanced && i >= MAX_NODES) {
				// Add 2 levels of nodes to the right branch
				right.setRight(new BinaryTreeNode<Integer>(++i));
				right.getRight().setRight(new BinaryTreeNode<Integer>(++i));
			}
		}
		tree.setRoot(root);
		return tree;
	}
	
	@Test
	public void testIsBalanced() {
		BalanceTestBinaryTree<Integer> tree = getBinaryTree(true);
		log(tree.print());
		log("Full traversal looks like:");
		tree.getHeight(tree.getRoot());
		log("Testing that the above tree is balanced:");
		Assert.assertTrue(tree.isBalanced());
	}
	
	@Test
	public void testIsUnBalanced() {
		BalanceTestBinaryTree<Integer> tree = getBinaryTree(false);
		log(tree.print());
		log("Full traversal looks like:");
		tree.getHeight(tree.getRoot());
		log("Testing that the above tree is NOT balanced:");
		Assert.assertFalse(tree.isBalanced());
	}
}
