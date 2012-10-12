package chapter01;

import java.util.Arrays;

import base.QuestionBase;

public class Question03 extends QuestionBase {

	@Override
	public String question() {
		return "Given two strings, write a method to decide if one is a permutation of the other";
	}

	/*
	 * This is a question about factorial permutation and combination. Which
	 * one, depends on how we account for duplicates. Lets assume that the input
	 * has all unique characters (permutation) n! Lets also assume nulls will
	 * not be provided Lets also assume that case does not matter Lets also
	 * assume that a string is not considered a permutation of another if they
	 * are equal
	 */

	public boolean isPermutation(String str1, String str2) {
		// TODO: Validate for uniqueness
		// TODO: Validate for nulls

		// Sort the chars and compare the result
		char[] arr1 = str1.toLowerCase().toCharArray();
		char[] arr2 = str2.toLowerCase().toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		boolean result = Arrays.equals(arr1, arr2);
		log(str2 + " permutation of " + str1 + " = " + result);
		return result;
	}
	
	public boolean isPermutationBookAnswer(String str1, String str2) {
		return true;
	}
}
