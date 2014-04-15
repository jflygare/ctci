package chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import base.BigO;

public class Question03 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Given two strings, write a method to decide if one is a permutation of the other";
	}


	public List<String> assumtions() {
		List<String> assumtionList = new ArrayList<String>();
		assumtionList.add("All chars must be used");
		assumtionList.add("Characters are case sensitive");
		assumtionList.add("String is ASCII (not Unicode)");
		return assumtionList;
	}

	public boolean isPermutation(String str1, String str2) {
		// TODO: Validate for nulls

		// Sort the chars and compare the result
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		// Linearithmic mergesorts
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean result = Arrays.equals(arr1, arr2);
		log(str2 + " permutation of " + str1 + " = " + result);
		return result;
	}
	
	public boolean isPermutationBookAnswer1(String str1, String str2) {
		// Check if strings are equal length... This I should have done!
		if (str1.length() != str2.length()) {
			return false;
		}
		
		// This solution is similar to mine, except it does increase size
		// by creating a string from the sorted array. Book argues readability..
		// questionable..
		return sort(str1).equals(sort(str2));
	}
	
	public boolean isPermutationBookAnswer2(String str1, String str2) {
		// Check if strings are equal length... This I should have done!
		if (str1.length() != str2.length()) {
			return false;
		}
		
		// This solution keeps an array of all possible char (ASCII)
		// counts. This solution has linear time complexity due to
		// needing to iterate over each string completely.
		
		// While keeping linear space complexity, the multiplier is smaller
		// than in my solution, needing to create only 1 copy of the string to char array.
		
		int[] letters = new int[256]; //ASCII
		char[] arr1 = str1.toCharArray();
		for (char c : arr1) {
			letters[c]++;
		}
		
		for (int i=0; i<str2.length(); i++) {
			int c = str2.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public String sort(String s) {
		char[] content = s.toCharArray();
		// Linearithmic mergesort
		Arrays.sort(content);
		return new String(content);
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR; //If using book solution. Otherwise linearithmic
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}
}
