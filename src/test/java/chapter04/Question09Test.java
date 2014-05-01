package chapter04;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;
import chapter04.ChapterQuestionBase.BinaryTree.BinaryTreeNode;
import chapter04.Question09.SumPathBinaryTree;

public class Question09Test extends QuestionTestBase<Question09> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question09());
	}
	
	private SumPathBinaryTree createTree() {
		// generate a 200 node tree with random numbers ranging
		// from 0 - 10
		int size = 200;
		Integer[] inputArray = new Integer[size];
		for (int i=0 ; i < size; i++) {
			double seed = Math.random();
			int number = (int)(seed * 10d);
			inputArray[i] = number;
		}
		return new SumPathBinaryTree(inputArray);
	}
	
	@Test
	public void testSumPaths() {
		SumPathBinaryTree tree = createTree();
		log(tree.print());
		Integer sum = 25;
		List<List<BinaryTreeNode<Integer>>> paths = tree.sumPaths(sum);
		for (List<BinaryTreeNode<Integer>> path : paths) {
			log(printPath(sum, path));
			Assert.assertEquals(sum, getPathSum(path));
		}
		
	}
	
	private Integer getPathSum(List<BinaryTreeNode<Integer>> pathList) {
		int sum = 0;
		for (BinaryTreeNode<Integer> node : pathList) {
			sum += node.getDatum();
		}
		return sum;
	}
	
	private String printPath(int sum, List<BinaryTreeNode<Integer>> pathList) {
		StringBuilder sb = new StringBuilder(sum + " : ");
		Iterator<BinaryTreeNode<Integer>> iter = pathList.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next().getDatum());
			if (iter.hasNext()) {
				sb.append(" -> ");
			}
		}
		return sb.toString();
	}
}
