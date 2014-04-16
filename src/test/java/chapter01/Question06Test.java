package chapter01;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question06Test extends QuestionTestBase<Question06> {


	@Before
	public void setUp() {
		setQuestionUnderTest(new Question06());
	}

	private byte[][][] createMatrix(int dim) {
		byte[][][] matrix = new byte[dim][dim][4];
		int count = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				matrix[i][j] = String.format("%04d", count++).getBytes();
			}
		}
		return matrix;
	}

	@Test
	public void testRotateMatrix() {
		int dim = 10;
		byte[][][] matrix = createMatrix(dim);
		System.out.println("Input Matrix:");
		getQuestionUnderTest().printMatrix(matrix);
		byte[][][] omatrix = getQuestionUnderTest().rotateMatrix(matrix);
		System.out.println("\nOutput Matrix:");
		getQuestionUnderTest().printMatrix(omatrix);
		// Test 4 corners. Not really a good test, but enough for the purpose
		byte[] c1 = matrix[0][0];
		byte[] c2 = matrix[0][dim - 1];
		byte[] c3 = matrix[dim - 1][0];
		byte[] c4 = matrix[dim - 1][dim - 1];
		assertTrue(Arrays.equals(c1, omatrix[0][dim - 1]));
		assertTrue(Arrays.equals(c2, omatrix[dim - 1][dim - 1]));
		assertTrue(Arrays.equals(c3, omatrix[0][0]));
		assertTrue(Arrays.equals(c4, omatrix[dim - 1][0]));
	}

	@Test
	public void testRotateMatrixInPlace() {
		int dim = 5;
		byte[][][] matrix = createMatrix(dim);
		// Test 4 corners. Not really a good test, but enough for the purpose
		byte[] c1 = matrix[0][0];
		byte[] c2 = matrix[0][dim - 1];
		byte[] c3 = matrix[dim - 1][0];
		byte[] c4 = matrix[dim - 1][dim - 1];
		System.out.println("Initial Matrix:");
		getQuestionUnderTest().printMatrix(matrix);
		getQuestionUnderTest().rotateMatrixInPlace(matrix);
		System.out.println("\nRotated Matrix:");
		getQuestionUnderTest().printMatrix(matrix);
		assertTrue(Arrays.equals(c1, matrix[0][dim - 1]));
		assertTrue(Arrays.equals(c2, matrix[dim - 1][dim - 1]));
		assertTrue(Arrays.equals(c3, matrix[0][0]));
		assertTrue(Arrays.equals(c4, matrix[dim - 1][0]));
	}

}
