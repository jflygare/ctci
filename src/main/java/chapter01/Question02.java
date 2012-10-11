package chapter01;

import java.nio.Buffer;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.annotation.Platform;

import base.QuestionBase;

@Platform(include="../chapter01/Question02.h")
public class Question02 extends QuestionBase {

	@Override
	public String question() {
		return "Implement a function 'void reverse(char* str)' in C or C++ which reverses a null-terminated string";
	}
	
	static { Loader.load(); }
	
	public static native void process(Buffer buffer, int size);
	

}
