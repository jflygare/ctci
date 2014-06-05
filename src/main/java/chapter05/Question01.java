package chapter05;

import base.BigO;

public class Question01 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "You are given two 32-bit numbers, N and M, and two bit positions, i and j. "
				+ "Write a method to insert M into N such that M starts at bit j and ends at bit i. "
				+ "You can assume that the bits j through i have enough space to fit all of M. "
				+ "That is, if M = 10011, you can assume that there are at least 5 bits between j and i. "
				+ "You would not, for example, have j = 3 and i = 2, because M could not fully "
				+ "fit between bit 3 and bit 2.\n" +
				"EXAMPLE:\n" +
				"Input:  N = 10000000000, M = 10011, i = 2, j = 6\n" +
				"Output: N = 10001001100";
	}
	
	public int insertBits(int n, int m, int i, int j) {
		int allOnes = ~0; // 11111111111111111111111111111111
		
		// Clear to the right of j
		int left = allOnes << (j + 1); // 11110000000
		
		// Clear to the left of i
		int right = ((1 << i) - 1); // 00000000011
		// 1         = 00000000001 // start with 1
		// 1 << i    = 00000000100 // move i (2) places = 4
		// (.. - 1)  = 00000000011 // subtract 1 = 3
		
		// All 1s except between j and i
		int mask = left | right; //11110000011
		
		// Clear bits j through i
		int n_cleared = n & mask; // 1000XXXXX00
		
		// Shift M into position
		int m_shifted = m << i; // 00001001100
		
		// Merge
		return n_cleared | m_shifted;
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.CONSTANT;
	}

}
