package chapter01;

import java.util.ArrayList;
import java.util.List;

import base.BigO;

public class Question07 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0";
	}

	/*
	 * Cannot change the matrix while iterating, otherwise values that were
	 * changed to 0 will be treated as if they were originally 0.
	 */

	/*
	 * Feels like there is some optimization we could do when writing the zeros,
	 * but an expression comparison is just as expensive as a write operation,
	 * so why do both?
	 */
	public void zeroOut(int[][] matrix) {
		log("Input Martix:");
		printMatrix(matrix);
		// Can use int[] in place of Point class if wanting to keep primitive
		// can use null terminated [] in place of Java List to keep primitive
		List<Point> zeroPointList = new ArrayList<Question07.Point>();
		// Pass through whole matrix once to get list of 0 coordinates
		// Done in O(n^2) time
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				int val = matrix[y][x];
				if (val == 0) {
					zeroPointList.add(new Point(x, y));
				}
			}
		}
		// Iterate through list, writing zeros to matrix
		for (Point p : zeroPointList) {
			zeroCross(p, matrix);
		}
		log("Output Martix:");
		printMatrix(matrix);
		
		// Time = ((O(n^2) + O(N)) = O(n^2)
		// Space = O(N)
		
		// If the matrix was symetric, we could half the loops
		// but would still be O(n^2)
		
		// The book answer is like mine, but using arrays to
		// hold the 0 locations.
	}

	public void zeroCross(Point p, int[][] matrix) {
		for (int x = 0; x < matrix[p.y].length; x++) {
			// Dont care what the current value is (read/write > write only)
			matrix[p.y][x] = 0;
		}
		for (int y = 0; y < matrix.length; y++) {
			// Dont care what the current value is (read/write > write only)
			matrix[y][p.x] = 0;
		}
		log("Zero cross at point: " + p);
		// printMatrix(matrix);
		
		// This function has O(N) time and O(1) space
	}

	public class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public void printMatrix(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				int val = matrix[y][x];
				sb.append("[" + val + "]");
			}
			sb.append("\n");
		}
		log(sb.toString());
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.QUADRADIC;
	}
}
