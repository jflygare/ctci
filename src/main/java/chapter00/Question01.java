package chapter00;

import base.BigO;


public class Question01 extends ChapterQuestionBase {

	private int hour;
	private int minute;

	public Question01(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	@Override
	public String question() {
		return "Given a time, calculate the angle between the hour and minute hands";
	}

	int calculateHandAngle() {
		// Accept any hour and modulus the value
		int mHour = hour % 12;

		// Accept any minute and modulus the value
		int mMinute = minute % 60;

		// Hour degrees
		int hDeg = (360 / 12) * mHour;
		// Minute degrees
		int mDeg = (360 / 60) * mMinute;

		// Absolute value of diff
		int angle = Math.abs(hDeg - mDeg);

		String output = "Input time = %02d:%02d - Output time = %02d:%02d - Angle = %d degrees";
		log(String.format(output, hour, minute, mHour, mMinute, angle));
		return angle;

	}

	int bookAnswer() {
		// This solution expects valid hour/mins (with a 0 base hour)
		//int angle = (int) (((30 * hour) - (5.5 * minute)) % 360);
		
		// The book is wrong.. but the formula can be reduced (with base 1 hour)
		int angle = Math.abs((30 * (hour % 12)) - (6 * minute));
		String output = "Book Answer: Input time = %02d:%02d - Angle = %d degrees";
		log(String.format(output, hour, minute, angle));
		return angle;
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		// Time to calculate is same for all input
		return BigO.CONSTANT;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		// Memory needed does not change with input
		return BigO.CONSTANT;
	}
}
