package chapter00;


public class Question01 extends ChapterQuestionBase {

	private int hour;
	private int minute;

	public Question01(int hour, int minute) {
		super();
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

		log("Input time = " + hour + ":" + minute + " Output time = " + mHour
				+ ":" + mMinute + " Angle = " + angle + " degrees");
		return angle;

	}

	int bookAnswer() {
		return (int) (((30 * hour) - (5.5 * minute)) % 360);
		// This solution only works for valid hour/mins (with a 0 base)
	}
}
