package base;

public abstract class QuestionBase {
	public abstract String question();
	public void log(String msg) {
		System.out.println(msg);
	}
}
