package chapter05;

import base.BigO;

public class Question04 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Explain what the following code does ((n & (n-1)) == 0)";
	}

	public String answer() {
		return "Determine if number is a base 2 root number (1,2,4,8,16,32)";
	}

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.CONSTANT;
	}

}
