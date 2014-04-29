package chapter04;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;
import chapter04.ChapterQuestionBase.BinaryTree.BinaryTreeNode;
import chapter04.Question04.LinkedListBinaryTree;

public class Question04Test extends QuestionTestBase<Question04> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question04());
	}

	private LinkedListBinaryTree<Integer> getBinaryTree() {
		int MAX_NODES = 16 - 1; // Base 2 number - 1
		LinkedListBinaryTree<Integer> tree = new LinkedListBinaryTree<Integer>();
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
		}
		tree.setRoot(root);
		return tree;
	}

	@Test
	public void testLevelLinkLists() {
		LinkedListBinaryTree<Integer> tree = getBinaryTree();
		log(tree.print());
		Map<Integer, LinkedList<BinaryTreeNode<Integer>>> listMap = tree
				.getLevelLists();
		for (Integer level : listMap.keySet()) {
			LinkedList<BinaryTreeNode<Integer>> levelList = listMap.get(level);
			log("Nodes in level: " + level);
			log(levelList.toString());
		}
	}
}
