package chapter05;

import base.BigO;

public class Question06 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write a program to swap odd and even bits in an integer with as few "
				+ "instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped "
				+ "and so on).";
	}

	public boolean getBit(int num, int bit) {
		return ((num & (1 << bit)) != 0);
	}

	public int setBit(int num, int bit, boolean one) {
		if (one) {
			return num | (1 << bit);
		} else {
			int mask = ~(1 << bit);
			return num & mask;
		}
	}

	public int swapBits(int num) {
		for (int i = 0; i < 32;) {
			int li = i++;
			int ri = i++;
			boolean l = getBit(num, li);
			boolean r = getBit(num, ri);
			num = setBit(num, li, r);
			num = setBit(num, ri, l);
		}
		return num;
	}

	// The book suggests a clever simple shift operation set

	public int swapOddEvenBits(int num) {
		// HEX reps of 10101010... and 01010101...
		return (((num & 0xaaaaaaaa) >> 1) | ((num & 0x55555555) << 1));
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.CONSTANT; // Always 32/2 loops
	}

}
