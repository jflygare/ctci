package chapter01;

import base.BigO;

public class Question04 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Write a method to replace all spaces in a string with '%20'. "
				+ "You may assume that the string has sufficient space at the end of the string to hold the additional characters, "
				+ "and that you are given the 'true' length of the string. "
				+ "(Note: if implementing in Java, please use a character array so that you can perform this peration in place.)\n"
				+ "EXAMPLE\n" + "Input:  'Mr John Smith    '\n"
				+ "Output: 'Mr%20John%20Smith'";
	}

	/*
	 * This question gives us some pretty clear conditions, which makes creating
	 * an algorithm more straight forward
	 */

	public void encode(char[] input) {
		// Could squeeze a bit more optimization by keeping track of how
		// many spaces were found and shaving that number *2 off the loop
		// would need to change the for loops to while loops
		for (int i = 0; i < input.length; i++) {
			log(i + ") " + String.valueOf(input));
			if (input[i] == ' ') {
				// Everything needs to be shifted 2 places
				// since we know we have extra room at the end, we can use
				// shift from the end and just replace the end positions
				for (int j = input.length - 3; j > i; j--) {
					// move char over 2 places
					input[j + 2] = input[j];
					log(i + " - " + j + ") " + String.valueOf(input));
				}
				// Now that everything is shifted
				// put in the %20
				// increase i while we are at it
				input[i++] = '%';
				input[i++] = '2';
				input[i] = '0'; // let loop increment i
			}
		}
	}
	
	public void encodeBookAnswer(char[] input, int length) {
		// My answer misinterpreted the criteria. The size of the input
		// array is irrelevant, other than it is sufficiently large.
		// The true length of the string.. minus the extra empty chars
		// is provided explicitly
		
		// Because we have this information, we can start from that position and move backwards
		// First, need to get the number of spaces.
		
		// Pass 1
		int spaceCount = 0;
		for (char c : input) {
			if (c == ' ') {
				spaceCount++;
			}
		}
		
		int newLength = length + (spaceCount * 2);
		input[newLength] = '\0';
		for (int i = length -1; i >=0; i--) {
			if (input[i] == ' ') {
				input[newLength -1] = '0';
				input[newLength -2] = '2';
				input[newLength -3] = '%';
				newLength = newLength -3;
			} else {
				input[newLength -1] = input[i];
				newLength = newLength -1;
			}
		}
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT; // Edits in-place. No extra space needed
	}
}
