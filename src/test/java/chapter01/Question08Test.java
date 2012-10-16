package chapter01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Question08Test {

	private Question08 sut = new Question08();

	@Test
	public void testIsRotation() {
		assertTrue(sut.isRotation("waterbottle", "erbottlewat"));
		assertTrue(sut.isRotation("waterbottle", "terbottlewa"));
		assertTrue(sut.isRotation("waterbottle", "aterbottlew"));
		assertTrue(sut.isRotation("waterbottle", "waterbottle"));
		assertFalse(sut.isRotation("waterbottle", "bottlewaterbottle"));
	}

}
