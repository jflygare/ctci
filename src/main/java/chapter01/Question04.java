package chapter01;

import base.QuestionBase;

public class Question04 extends QuestionBase {

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
	 * This question gives us some pretty clear conditions, which makes creating an algorithm more straight forward
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

	public void encodeBookAnswer(char[] input) {

	}
}
