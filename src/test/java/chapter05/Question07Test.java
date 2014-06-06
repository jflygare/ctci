package chapter05;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

public class Question07Test extends QuestionTestBase<Question07> {

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question07());
	}
	
	private boolean[][] createTestArray(int size, int missingNum) {
		// can only max out at 15 given the 4 bit int size
		boolean[][] data = new boolean[size][Question07.INT_BITS];
		for (int i=0; i<size; i++) {
			int num = (i < missingNum) ? i : i + 1;
			data[i] = fromInt(num);
		}
		return data;
	}
	
	private boolean[] fromInt(int num) {
		boolean[] bits = new boolean[Question07.INT_BITS];
		for (int i=0; i<Question07.INT_BITS; i++) {
			bits[i] = ((num & 1) == 1);
			num >>= 1;
		}
		return bits;
	}
	
	@Test
	public void testFindMissingNum() {
		int size = 11;
		int missingNum = 9;
		boolean[][] data = createTestArray(size, missingNum);
		int result = getQuestionUnderTest().findMissingNumber(data);
		Assert.assertEquals(missingNum, result);
	}
}
