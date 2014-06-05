package chapter05;

import base.BigO;

public class Question02 extends ChapterQuestionBase {

	public static final String ERROR = "ERROR";

	@Override
	public String question() {
		return "Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, "
				+ "print the binary representation. If the number cannot be represented accurately in binary with "
				+ "at most 32 characters, print \"ERROR\"";
	}

	// Even after reading the solution in the book, this question did not make
	// sense to me.
	// What is the point of binary representation of a fraction?
	// The code below comes from the book and errors out for the input suggested
	// by the question.

	public String printBinary(double num) {
		if (num >= 1 || num <= 0) {
			return ERROR;
		}

		StringBuilder binary = new StringBuilder(".");
		while (num > 0) {
			if (binary.length() >= 32) {
				return ERROR + ": " + binary;
			}

			double r = num * 2;
			if (r >= 1) {
				binary.append(1);
				num = r - 1;
			} else {
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Because of stringbuilder
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}

}
