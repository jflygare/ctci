package chapter01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Question02Test {
	
	@Test
	public void testReverse() {
		byte[] str = "This is a string\0".getBytes(); //Terminate with null char \0
		System.out.println("The original Java string: " + new String(str));
		Question02.reverse(str);
		System.out.println("The reversed Java string: " + new String(str));
		assertEquals("gnirts a si sihT\0", new String(str));
	}

}
