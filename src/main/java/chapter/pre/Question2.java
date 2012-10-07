package chapter.pre;

//import java.util.Collections;
import java.util.Arrays;
import java.util.Set;

import base.QuestionBase;

public class Question2 extends QuestionBase {
	
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
		
		// Could iterate, but a bin search?  would be faster given what we know about the array
		return minHalf(set)[0];
	}
	
	public int[] minHalf(int[] set) {
		log("Halfing array: " + Arrays.toString(set));
		int mIndex = (set.length / 2); //Rounds down
		int lIndex = set.length - 1;
		log("Mid index = " + mIndex + " Last index = " + lIndex);
		if (mIndex == lIndex) {
			// Found element
			int val = set[mIndex];
			log("Found min element: " + val);
			return new int[]{val};
		} else if (set[mIndex] > set[lIndex]) {
			log("Min element in last half");
			//Arrays.copyOfRange(set, mIndex, lIndex); //Faster code way
			int range = lIndex - mIndex +1; //Include mIndex value
			int[] nSet = new int[range];
			for (int i=0; i < range; i++) {
				nSet[i] = set[mIndex + i];
			}
			return minHalf(nSet);
		} else {
			log("Min element in first half");
			//Arrays.copyOfRange(set, 0, mIndex); //Faster code way
			int range = mIndex +1; //Include mIndex value
			int[] nSet = new int[range];
			for (int i=0; i < range; i++) {
				nSet[i] = set[i];
			}
			return minHalf(nSet);
		}
	}
	
}
