package chapter01;

import java.util.ArrayList;
import java.util.List;

import base.BigO;

public class Question01 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement an algorithm to determine if a string has all unique characters."
				+ "What if you cannot use additional data structures";
	}

	public List<String> assumtions() {
		List<String> assumtionList = new ArrayList<String>();
		assumtionList.add("String cannot contain multiple lines");
		assumtionList.add("Characters are case sensitive");
		assumtionList.add("String is ASCII (not Unicode)");
		assumtionList.add("Spaces do count if duplicated");
		return assumtionList;
	}

	public boolean hasAllUniqueCharactersRegularExpression(String string) {
		// Just thought I would put this in here... Not sure what the performance is
		// Use lookahead to match captured char down string
		return string.matches("^(?:(.)(?!.*\\1))*\\z");
	}

	public boolean hasAllUniqueCharactersBruteForce(String string) {
		// This algorithm has exponential time complexity. Booooo!
		log("Checking " + string + " for unique characters");
		// Cannot use additional data structures.. Must i/j iterate
		for (int i = 0; i < string.length(); i++) {
			for (int j = i + 1; j < string.length(); j++) {
				log("Checking " + string.charAt(i) + " against "
						+ string.charAt(j));
				if (string.charAt(i) == string.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	public boolean hasAllUniqueCharactersBookAnswer1(String string) {
		// First, if the string is larger that 256 (8-bit ASCII)
		// we know there are multiple chars. (Why would 128 not work
		// if we know it is ASCII?)
		if (string.length() > 256) return false;
		
		// Create an boolean array whos index maps to every possible character
		// Iterate through the string, as soon as a duplicate is found, return false
		boolean[] charSet = new boolean[256];
		for (int i=0; i < string.length(); i++) {
			int charIndex = string.charAt(i);
			if (charSet[charIndex]) {
				log("Duplicate char " + (char)charIndex + " found in string position: " + i);
				return false;
			}
			charSet[charIndex] = true;
		}
		log("String is unique");
		return true;
		/**
		 * The time complexity is O(n) and space complexity is O(1)
		 */
	}
	

	public boolean hasAllUniqueCharactersBookAnswer2(String string) {
		// This algorithm improves on the first by reducing the space complexity X8
		// by using a bit vector to track the found chars:
		// (boolean[256] : 256 bits) / (int : 32 bits) = 8
		// This only works for letters a-z! (no spaces)
		if (string.length() > 256) return false;
		
		int checker = 0;
		for (int i=0; i < string.length(); i++) {
			int val = string.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}
}
