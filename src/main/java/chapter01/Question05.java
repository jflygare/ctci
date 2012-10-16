package chapter01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question05 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement a method to perform basic string compression using the counts of repeated characters. "
				+ "For example, the string aabcccccaaa would become a2b1c5a3. If the 'compressed' string would not become smaller "
				+ "than the original string, your method should return the original string";
	}

	/*
	 * In order for the string to become smaller, there cannot be more single
	 * and double chars than space saved by chars with more repeats Assume that
	 * input is all in same case Assume null is not passed in
	 */

	// My answer using regular expression
	public String compressShortAnswer(String input) {
		log("Compressing string: " + input);
		StringBuilder sb = new StringBuilder();
		Matcher matcher = Pattern.compile("(.)(\\1*)").matcher(input);
		while (matcher.find()) {
			// Groups represent unique letter clusters
			String group = matcher.group();
			log("Found char group [" + group + "] in " + input);
			int size = group.length();
			sb.append(group.charAt(0));
			sb.append(size);
			log("Current compressed string: " + sb.toString());
		}
		String output = sb.toString();
		boolean shorter = output.length() < input.length();
		log(output + " shorter than " + input + " = " + shorter);
		return (shorter) ? output : input;
	}

	// Using algorithm and simple data types
	public String compress(String input) {
		log("Compressing string: " + input);
		// Prime the loop with first char in string
		char last = input.charAt(0);
		String output = String.valueOf(last); // Append first char
		int count = 1;
		int i = 1;
		while (i < input.length()) {
			char ch = input.charAt(i++); // Assign char then increment
			if (ch != last) {
				output += String.valueOf(count); // Append count
				output += String.valueOf(ch); // Start new char test
				last = ch;
				count = 1;
			} else {
				count++;
			}
		}
		output += String.valueOf(count); // Append last count
		boolean shorter = output.length() < input.length();
		log(output + " shorter than " + input + " = " + shorter);
		return (shorter) ? output : input;
	}
}
