package chapter03;

import base.BigO;

public class Question01 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Describe how you could use a single array to implement three stacks";
	}

	/*
	 * Not sure I really understand the question. First things that come to mind
	 * are, array of arrays Object[][] where each element is an array
	 * representing a stack. Or the element array is a fixed size, with 0
	 * element is a number representing which stack it belongs, and 1 element
	 * with the datum.
	 * 
	 * Another way might be to have the array divided by 3 with a known number
	 * of elements for each. The array can be grown, by creating a new, bigger
	 * array and copying the elements to it.
	 * 
	 * None of these feel like it is what they are looking for.
	 * 
	 * Going to skip to answer section to see if I can get more clues without
	 * noticing how it was implemented.
	 */

	/*
	 * After skipping to the answers to see what they were asking for, it
	 * appears my first thoughts were close. I am not sure why they included
	 * this question other than to make one think about the limitations of
	 * arrays. One of the proposed solutions the book admits would be too
	 * elaborate to be appropriate for an interview question. I am going to skip
	 * this exercise.
	 */

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.UNKNOWN;
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.UNKNOWN;
	}
}
