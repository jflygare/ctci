package chapter01;

public class Question06 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, "
				+ "write a method to rotate the image by 90 degrees. Can you do this in place?";
	}

	/*
	 * By the "in place" criteria, I think they want this solved using simple
	 * array matrixes ([row][colum][byte index])
	 */

	public byte[][][] rotateMatrix(byte[][][] matrix) {
		// Solve using new matrix (simpler algorithm)
		int dim = matrix.length;
		byte[][][] newm = new byte[dim][dim][4]; // NxN with 4byte cells
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				int y = j;
				int x = Math.abs(i - dim) - 1;
				log(j + "-" + i + " | " + x + "-" + y);
				newm[y][x] = matrix[i][j];
			}
		}
		return newm;
	}

	/*
	 * I must admit I came to this solution only by playing with inputs and
	 * interpreting the outputs. I tried to do much of it on paper, but is very
	 * difficult to keep track of evolving ideas with lots of data on paper.
	 * Once I arrived at the answer, it seems much less complicated. I could NOT
	 * have done this on a white board. I need more practice.
	 */
	public void rotateMatrixInPlace(byte[][][] matrix) {
		// Change values in place
		// Use temp cell and rotate cells in concentric squares, moving inward.
		int dim = matrix.length;
		for (int i = 0; i < dim - 1; i++) {
			log("---------------------------------------");
			// Move to inner boxes
			for (int j = i; j < dim - (i + 1); j++) {
				System.out.println("Starting at {" + i + "-" + j + "} rotate:");
				printMatrix(matrix);
				log("-----------");
				int x = i;
				int y = j;
				byte[] tmp = matrix[y][x];
				for (int k = 0; k < 4; k++) {
					// Rotate cell on all 4 sides
					String was = x + "-" + y;
					int t = y;
					y = x;
					x = Math.abs(t - dim) - 1;
					String now = x + "-" + y;
					log(was + " | " + now);
					// Move value in target cell to tmp
					byte[] last = tmp;
					tmp = matrix[y][x];
					// Move last value into target
					matrix[y][x] = last;
				}
			}
		}
	}

	public void printMatrix(byte[][][] matrix) {
		StringBuilder sb = new StringBuilder();
		int dim = matrix.length;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				sb.append('[');
				sb.append(new String(matrix[i][j]));
				sb.append("] ");
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}
