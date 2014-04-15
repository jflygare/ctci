package chapter01;

import base.BigO;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Platform;

@Platform(include = "../chapter01/Question02.h")
public class Question02 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "Implement a function 'void reverse(char* str)' in C or C++ which reverses a null-terminated string";
	}

	static {
		Loader.load();
	}

	public static native void reverse(@Cast("char*") byte[] str);
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.CONSTANT;
	}

}
