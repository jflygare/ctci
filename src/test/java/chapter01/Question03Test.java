package chapter01;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Question03Test {
	
	private Question03 sut = new Question03();
	private String SOURCE = "part";
	@SuppressWarnings("serial")
	private Map<String, Boolean> examplesMap = new HashMap<String, Boolean>() {{
		put("tarp", true);
		put("carp", false);
		put("parts",false);
		}};

	@Test
	public void testIsPermutation() {
		for (String str : examplesMap.keySet()) {
			assertEquals(examplesMap.get(str), sut.isPermutation(SOURCE, str));
		}
	}

}
