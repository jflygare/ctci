package base;


public abstract class QuestionBase {
	
	public QuestionBase() {
		describe();
	}

	public abstract String question();

	public void log(String msg) {
		System.out.println(msg);
	}

	public abstract String answersUrl();
	
	//public abstract BigO optimalSpaceComplexity();
	
	//public abstract BigO optimalTimeComplexity();

	public BigO solutionSpaceComplexity() {
		return BigO.UNKNOWN;
	}

	public BigO solutionTimeComplexity() {
		return BigO.UNKNOWN;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("-----------------------------------------------------------------\n");
		sb.append(question());
		sb.append("\n");
		sb.append("- Solution time complexity: " + solutionTimeComplexity());
		sb.append("\n");
		sb.append("- Solution space complexity: " + solutionSpaceComplexity());
		sb.append("\n");
		sb.append("- Answer details: " + answersUrl());
		sb.append("\n");
		return sb.toString();
	}
	
	public void describe() {
		log(toString());
	}
}
