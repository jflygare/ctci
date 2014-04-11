package base;

import org.junit.After;
import org.junit.Assert;

public abstract class QuestionTestBase<T extends QuestionBase> {
	
	private T questionUnderTest;
	
	protected void setQuestionUnderTest(T questionUnderTest) {
		this.questionUnderTest = questionUnderTest;
	}
	
	protected T getQuestionUnderTest() {
		return questionUnderTest;
	}
	
	public void log(String msg) {
		System.out.println(msg);
	}
	
	public void describeQuestion() {
		
	}

	@After
	public void validateBigO() {
		Assert.assertNotNull("Must provide question under test", questionUnderTest);
		Assert.assertTrue(
				"Must define time complexity",
				(getQuestionUnderTest().solutionTimeComplexity() != BigO.UNKNOWN));
		Assert.assertTrue(
				"Must define space complexity",
				(getQuestionUnderTest().solutionSpaceComplexity() != BigO.UNKNOWN));
	}
}
