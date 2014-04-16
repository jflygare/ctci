package chapter01;

import base.BigO;


public class Question08 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Assume you have a method isSubstring which checks if one word is a "
				+ "substring of another. Given two strings, s1 and s2, write code to check if s2 is a "
				+ "rotation of s1 using only one call to isSubstring "
				+ "(e.g., 'waterbottle' is a rotation of 'erbottlewat'";
	}

	/*
	 * I am interpereting this question to mean that isSubstring is code that
	 * exists, takes 2 strings and returns a booolean. And that I should create
	 * an algorithm that utilizes a call to this method, but only once.
	 * 
	 * Assume is case sensitive Assume equal strings count as rotation
	 */

	/*
	 * Simulate "existing" isSubstring
	 */
	public boolean isSubstring(String s1, String s2) {
		boolean result = s1.contains(s2);
		log(s2 + " substring of " + s1 + " = " + result);
		return result;
	}

	public boolean isRotation(String s1, String s2) {
		// if strings are of same length,
		// add the first to its self and see if it contains the second
		if (s1.length() == s2.length()) {
			String compStr = s1 + s1;
			return isSubstring(compStr, s2);
		} else {
			// Cannot be rotation if different lengths
			return false;
		}
		
		// This solution is identical to book
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.QUADRADIC; // Assuming we must take the isSubstring complexity into account
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Always double the size of input
	}
}
