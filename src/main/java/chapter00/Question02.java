package chapter00;

//import java.util.Collections;
import java.util.Arrays;
import java.util.Set;

import base.QuestionBase;

public class Question02 extends QuestionBase {
	
	//private Set<Integer> set;
	private int[] set = new int[]{3, 4, 5, 6, 7, 1, 2};


	@Override
	public String question() {
		return "A sorted array has been rotated so that the elements might appear in the order [3 4 5 6 7 1 2]"
				+ "How would you find the minimum element? You may assume that the array has all unique elements";
	}
	
	public int minElement() {
		// Of course this is how I would do in Java... but...
		//return Collections.min(set);
		
		// Could iterate, but a bin search  would be faster given what we know about the array
		return findMinElement(0, set.length -1);
	}
	
	public int findMinElement(int sIndex, int eIndex) {
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
			return findMinElement(mIndex, eIndex);
		} else {
			log("Min element in first half");
			return findMinElement(0, mIndex);
		}
	}
}
