package chapter05;

import base.BigO;

public class Question05 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write a function to determine the number of bits required to "
				+ "convert integer A to integer B.\n" + "EXAMPLE:\n"
				+ "Input: 31, 14\n" + "Output: 2";
	}

	// 31 = 011111
	// 14 = 001110
	// XOR the numbers to get mask. Then count the ones
	// 31 ^ 14 = 010001

	public int convertBits(int i, int j) {
		// xor the values
		int mask = i ^ j;
		// count the 1s
		int count = 0;
		while (mask > 0) {
			if ((mask & 1) == 1) {
				count++;
			}
			mask >>= 1;
		}
		return count;
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LOGARITHMIC; // Bit shift operations are power of 2
	}

}
