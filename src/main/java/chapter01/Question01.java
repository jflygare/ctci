package chapter01;

import java.util.ArrayList;
import java.util.List;

import base.QuestionBase;

public class Question01 extends QuestionBase {

	@Override
	public String question() {
		return "Implement an algorithm to determine if a string has all unique characters."
				+ "What if you cannot use additional data structures";
	}
	
	public List<String> assumtions() {
		List<String> assumtionList = new ArrayList<String>();
		assumtionList.add("String cannot contain multiple lines");
		assumtionList.add("Characters are case sensitive");
		return assumtionList;
	}

	public boolean hasAllUniqueCharactersShortAnswer(String string) {
		// Use lookahead to match captured char down string
		return string.matches("^(?:(.)(?!.*\\1))*\\z");
	}
	
	public boolean hasAllUniqueCharacters(String string) {
		log("Checking " + string + " for unique characters");
		// Cannot use additional data structures.. Must i/j iterate
		for (int i=0; i < string.length(); i++) {
			for (int j=i+1; j < string.length(); j++ ) {
				log("Checking " + string.charAt(i) + " against " + string.charAt(j));
				if (string.charAt(i) == string.charAt(j)) return false;
			}
		}
		return true;
	}
	
	public boolean hasAllUniqueCharactersBookAnswer(String string) {
		return false;
	}
}
