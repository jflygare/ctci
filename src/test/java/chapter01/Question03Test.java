package chapter01;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question03Test extends QuestionTestBase<Question03>{
	
	private String SOURCE = "part";
	
	@SuppressWarnings("serial")
	private Map<String, Boolean> examplesMap = new HashMap<String, Boolean>() {{
		put("tarp", true);
		put("carp", false);
		put("parts",false);
		}};
		
	@Before
	public void setUp() {
		setQuestionUnderTest(new Question03());
	}

	@Test
	public void testIsPermutation() {
		for (String str : examplesMap.keySet()) {
			assertEquals(examplesMap.get(str), getQuestionUnderTest().isPermutation(SOURCE, str));
		}
	}

	@Test
	public void testIsPermutationBookAnswer1() {
		for (String str : examplesMap.keySet()) {
			assertEquals(examplesMap.get(str), getQuestionUnderTest().isPermutationBookAnswer1(SOURCE, str));
		}
	}
	
	@Test
	public void testIsPermutationBookAnswer2() {
		for (String str : examplesMap.keySet()) {
			assertEquals(examplesMap.get(str), getQuestionUnderTest().isPermutationBookAnswer1(SOURCE, str));
		}
	}

}
