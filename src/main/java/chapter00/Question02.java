package chapter00;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;

import base.BigO;

//import java.util.Collections;

public class Question02 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "A sorted array has been rotated so that the elements might appear in the order [3 4 5 6 7 1 2]\n"
				+ "How would you find the minimum element? You may assume that the array has all unique elements";
	}

	public int findMinElement(final int[] set) {
		// I would likely use ArrayUtils (commons-lang) or
		// natively in Java...
		//return Collections.min(new AbstractList<Integer>() {
		//	public Integer get(int index) {
		//		return set[index];
		//	}
		//	public int size() {
		//		return set.length;
		//	}
		//});
		// but... the point is to exercise algorithms.
		// and... That method has linear time complexity,
		// which is sub optimal given that we know the list is sorted

		// Could iterate, but a bin search would be faster given what we know
		// about the array
		return findMinElement(set, 0, set.length - 1);
	}

	public int findMinElement(int[] set, int sIndex, int eIndex) {
		int mIndex = ((eIndex - sIndex) / 2) + sIndex;
		if (set[mIndex] < set[sIndex] && set[mIndex] < set[eIndex]) {
			// Found element
			int val = set[mIndex];
			log("Found min element: " + val);
			return val;
		}
		log("Halfing array: Mid index = " + mIndex);
		if (set[mIndex] > set[eIndex]) {
			log("Min element in last half");
			return findMinElement(set, mIndex, eIndex);
		} else {
			log("Min element in first half");
			return findMinElement(set, sIndex, mIndex);
		}
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LOGARITHMIC;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}
}
