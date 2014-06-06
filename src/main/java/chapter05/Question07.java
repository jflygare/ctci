package chapter05;

import base.BigO;

public class Question07 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "An array A contains all the integers from 0 to n, except for one number which is "
				+ "missing. In this problem, we cannot access an entire integer in A with a single operation. "
				+ "The elements of A are represented in binary, and the only operation we can use "
				+ "to access them is \"fetch the jth bit of A[i]\", which takes constant time. Write code to find "
				+ "the missing integer. Can you do it in O(n) time?";
	}
	
	public static final int INT_BITS = 4; //Use 4 bit numbers for simplicity sake
	
	// My impression of this question is that we can still do a binary search in O(log n) time because
	// the operation to transform a bit array into an integer is constant time.
	// The book suggests a clever use of recursively comparing the parity of the LSB until the missing
	// value is found. But this runs in O(n) time.
	
	public int findMissingNumber(boolean[][] array) {
		//TODO: Check for min/max conditions
		
		int missingNum = findMissingNumber(array, 0, array.length -1);
		// Check unexpected condition, just to be thorough
		if (missingNum == -1) {
			throw new IllegalArgumentException("Array did not contain missing number");
		}
		log("Missing number = " + missingNum);
		return missingNum;
	}
	
	public int findMissingNumber(boolean[][] array, int i, int j) {
		log("Searching indexes [" + i + "] to [" + j + "]");
		int iVal = toInt(array[i]);
		int jVal = toInt(array[j]);
		// If we got here and are 2 consecutive indexes,
		// the missing number must be one the index values
		if (j - i == 1) {
			return (iVal == i) ? j : i;
		}
		if (iVal == i && jVal == j) {
			return -1; // missing number is not in range
		}
		
		int mid = i + ((j - i) / 2);
		int lower = findMissingNumber(array, i, mid);
		if (lower > -1) {
			return lower;
		} else {
			return findMissingNumber(array, mid + 1, j);
		}
	}
	
	public int toInt(boolean[] array)
	{
		// TODO: Validate array size
		// This appears to be an O(n) time operation
		// but really always runs in constant time
		int num = 0;
		for (int i = 0; i < INT_BITS; i++) {
			if (array[i]) {
				num += Math.pow(2, i);
			}
		}
		log(num + " = " + printBits(array));
		return num;
	}
	
	// Only creating function to illustrate constraint condition
	public boolean findBit(boolean[][] array, int j, int i) {
		return array[i][j];
	}
	
	public String printBits(boolean[] bits) {
		StringBuilder sb = new StringBuilder();
		for (boolean b : bits) {
			String v = (b) ? "1" : "0";
			sb.append(v);
		}
		return sb.toString();
	}
	

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Due to recursive algorithm. Could be CONSTANT if using iterative
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LOGARITHMIC; // Better than books solution.. finally
	}

}
