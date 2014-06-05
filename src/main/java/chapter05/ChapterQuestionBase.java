package chapter05;

import base.QuestionBase;

public abstract class ChapterQuestionBase extends QuestionBase {

	@Override
	public String answersUrl() {
		return "https://code.google.com/p/ctci/source/browse/trunk/Java/Chapter+5";
	}
	
	public String printBinary(int num) {
		if (num < 1) {
			throw new IllegalArgumentException("Must be positive integer");
		}
		if (num == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder(num + " = [");
		while (num > 0) {
			if ((num & 1) == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			num >>= 1;
		}
		sb.append("]");
		return sb.toString();
	}

}
