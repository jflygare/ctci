package chapter05;

import base.BigO;

public class Question03 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given a positive integer, print the next smallest and the next largest "
				+ "number that have the same number of 1 bits in their binary representation";
	}

	// brute force approach:
	// count 1s in binary representation, then compare to count of
	// incremental/decremental number until match

	public int countOnes(int num) {
		int ones = 0;
		while (num > 0) {
			if ((num & 1) == 1) {
				ones++;
			}
			num >>= 1;
		}
		return ones;
		// This is a logarithmic loop since each iteration is a base 2
	}

	public int bruteNext(int num) {
		int count = countOnes(num);
		for (int i = num + 1; i < Integer.MAX_VALUE; i++) {
			if (count == countOnes(i)) {
				return i;
			}
		}
		return -1; // next not found
		// LINEARITHMIC O(n log n)
	}

	public int brutePrev(int num) {
		int count = countOnes(num);
		for (int i = num - 1; i > 0; i--) {
			if (count == countOnes(i)) {
				return i;
			}
		}
		return -1; // next not found
		// LINEARITHMIC O(n log n)
	}

	// The book suggests a way to do using bit manipulation. I realize my
	// solution is brute force
	// and the interviewer would want to see a more interesting solution.

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LOGARITHMIC; // If using book solution. Brute force is
									// LINEARITHMIC
	}

}
