package chapter01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class Question07Test {

	private Question07 sut = new Question07();

	private int[][] createMatrix(int rows, int cols) {
		Random rand = new Random();
		int[][] matrix = new int[rows][cols];
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				matrix[y][x] = rand.nextInt(5);
			}
		}
		return matrix;
	}

	@Test
	public void testZeroOutRandom() {
		sut.zeroOut(createMatrix(5, 7));
		// Would take just as much coding to validate the algorithm.
		// This test is just to eyeball a bunch of different matrixes
	}

	@Test
	public void testZeroOut() {
		int[][] matrix = new int[][] { { 4, 3, 3, 3, 1, 3, 3 },
				{ 3, 1, 4, 0, 1, 1, 2 }, { 3, 3, 3, 4, 2, 4, 4 },
				{ 3, 0, 1, 0, 3, 0, 1 }, { 3, 2, 4, 4, 0, 0, 4 } };

		int[][] outMatrix = new int[][] { { 4, 0, 3, 0, 0, 0, 3 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 3, 0, 3, 0, 0, 0, 4 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		for (int i = 0; i < matrix.length; i++) {
			assertFalse(Arrays.equals(matrix[i], outMatrix[i]));
		}
		sut.zeroOut(matrix);
		for (int i = 0; i < matrix.length; i++) {
			assertTrue(Arrays.equals(matrix[i], outMatrix[i]));
		}
	}

}
