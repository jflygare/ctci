package chapter01;

import base.QuestionBase;

public class Question06 extends QuestionBase {

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
				int newi = j;
				int newj = Math.abs(i - dim) - 1;
				log(i + "-" + j + " | " + newi + "-" + newj);
				newm[newi][newj] = matrix[i][j];
			}
		}
		return newm;
	}

	public void rotateMatrixInPlace(byte[][][] matrix) {
		//

	}

	public void rotateMatrixBookAnswer() {

	}
}