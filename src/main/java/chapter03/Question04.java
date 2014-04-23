package chapter03;

import java.util.ArrayList;
import java.util.List;

import base.BigO;

public class Question04 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "In the classic problem of the towers of Hanoi, you have 3 towers and N disks of different "
				+ "sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order "
				+ "of size from top to bottom (i.e. each disk sits on top of an even larger one). You have the "
				+ "following constraints: 1) Only one disk can be moved at a time. 2) A disk is slid off the top "
				+ "of one tower on the next tower. 3) A disk can only be placed on top of a larger disk. Write "
				+ "program to move the disks from the first tower to the last using stacks";
	}

	public static class Hanoi {
		public class Ring {
			private int num;

			public Ring(int num) {
				this.num = num;
			}
		}

		private int rings;
		private List<Generics.Stack<Ring>> towerList = new ArrayList<Generics.Stack<Ring>>();

		public Hanoi() {
			this(5); // Default
		}

		public Hanoi(int rings) {
			this.rings = rings;
			Generics.Stack<Ring> tower1 = new Generics.Stack<Ring>();
			for (int i = rings; i > 0; i--) {
				tower1.push(new Ring(i));
			}
			towerList.add(tower1);
			towerList.add(new Generics.Stack<Ring>());
			towerList.add(new Generics.Stack<Ring>());
		}

		public int solve() {
			log("#### Start (" + rings + " rings) :");
			print();
			int moves = 0;
			Ring last = null;
			while ((last = move(last)) != null) {
				log("#### " + ++moves);
				print();
			}
			log("#### Finish (" + moves + " moves):");
			return moves;
		}

		// (2^n)-1 moves = O(2^n) time complexity
		private Ring move(Ring last) {
			for (int i = 0; i < towerList.size(); i++) {
				Generics.Stack<Ring> tower = towerList.get(i);
				// Do not move ring back
				if (tower.size > 0 && tower.peek() != last) {
					int ring = tower.peek().num;
					// Determine which tower to move ring to if any
					// If even number of rings, look to move to next tower
					// first,
					// else look to move to tower after next (looping around)
					// (Doing this will save on the number of moves it takes to
					// finish)
					Generics.Stack<Ring> t1 = towerList
							.get((i + ((rings % 2 == 0) ? 1 : 2))
									% towerList.size());
					Generics.Stack<Ring> t2 = towerList
							.get((i + ((rings % 2 == 0) ? 2 : 1))
									% towerList.size());
					Generics.Stack<Ring> target = null;
					// Find next suitable target tower
					if (t1.size == 0 || t1.peek().num > ring) {
						target = t1;
					} else if (t2.size == 0 || t2.peek().num > ring) {
						target = t2;
					}
					// If target tower found, move ring
					if (target != null) {
						Ring r = tower.pop();
						target.push(r);
						return r;
					}
				}
			}
			return null; // Not able to move
		}

		public void log(String msg) {
			System.out.println(msg);
		}

		private void printRing(int size, StringBuilder sb) {
			StringBuilder sbr = new StringBuilder();
			int offset = rings - size;
			for (int i = 0; i < rings; i++) {
				if (i < offset) {
					sbr.append(' ');
				} else {
					sbr.append('=');
				}
			}
			sb.append(sbr.toString());
			sb.append('|');
			String half = sbr.reverse().toString();
			sb.append(half);
		}

		private void printTower(Generics.Stack<Ring> tower, int level,
				StringBuilder sb) {
			int offset = rings - tower.size;
			if (level < offset) {
				printRing(0, sb);
			} else {
				printRing(tower.peekTo(level - offset).num, sb);
			}
		}

		public void print() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < rings; i++) {
				sb.append(' ');
				for (int j = 0; j < towerList.size(); j++) {
					printTower(towerList.get(j), i, sb);
					sb.append(' ');
				}
				sb.append('\n');
			}
			// Print base
			for (int i = 0; i < (((rings * 2) + 3) * 3); i++) {
				sb.append('-');
			}
			log(sb.toString());
		}
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.EXPONENTIAL;
	}
}
