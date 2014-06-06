package chapter05;

import base.BigO;

public class Question08 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "A monochrome screen is stored as a single array of bytes, allowing eight "
				+ "consecutive pixels to be stored in one byte. The screen has width w, where w is devisible "
				+ "by 8 (that is, no byte will be split across rows). The height of the screen, "
				+ "of course, can be derived from the length of the array and the width. Implement a funtion "
				+ "drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) which "
				+ "draws a horizontal line from (x1, y) to (x2, y)";
	}
	
	public static final int PIXEL_BITS = 8;
	
	public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		//TODO validate input
		// Assume the input screen is zeroed out
		
		int bytesPerRow = (width / PIXEL_BITS);
		
		// brute force (O(n))
		for (int i=0; i < bytesPerRow; i++) {
			for (int j=0; j<PIXEL_BITS; j++) {
				int pixelIndex = (i * PIXEL_BITS) + j;
				if (pixelIndex >= x1 && pixelIndex <= x2) {
					// Set bit
					int bitIndex = (y * bytesPerRow) + i;
					screen[bitIndex] |= (1 << j);
				}
			}
		}
	}
	
	public String printScreen(byte[] screen, int width) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<screen.length; i += width / PIXEL_BITS) {
			sb.append(String.format("%03d:", i));
			for (int j=0; j<width / PIXEL_BITS; j++) {
				byte b = screen[i + j];
				for (int k=0; k<PIXEL_BITS; k++) {
					if ((b & 1) == 1) {
						sb.append("XX");
					} else {
						sb.append("--");
					}
					b >>= 1;
				}
				sb.append("|");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	// I knew my solution was going to be brute force.. I new a more interesting solution would be to
	// identify full blocks that could be masked at once. I did not attempt to find a "better" solution
	// before peeking at the solution in the book. While the book solution does flip whole bytes at a time
	// if it can, the algorithm is way more complex and does not really provide better asymptotic performance.

	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR; // Due to recursive algorithm. Could be CONSTANT if
							// using iterative
	}

	@Override
	public BigO solutionTimeComplexity() {
		return BigO.LOGARITHMIC; // Better than books solution.. finally
	}

}
