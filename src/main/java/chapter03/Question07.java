package chapter03;

import java.util.LinkedList;

import base.BigO;

public class Question07 extends ChapterQuestionBase {

	@Override
	public String question() {
		return "An animal shelter holds only dogs and cats, and operates on "
				+ "a strictly 'first in, first out' basis. People must adopt either the "
				+ "'oldest' (based on arrival time) of all animals at the shelter, or they can "
				+ "select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). "
				+ "They cannot select which specific animal they would like. Create the data structures to "
				+ "maintain this system and implement operations such as 'enqueue/dequeueAny/dequeueDog/dequeueCat'. "
				+ "You may use the build-in LinkedList data structure";
	}

	// Assume no null input
	// This seems a bit too simple (out of place)

	public static class AnimalShelter {
		public static abstract class Animal {
			private String name;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Animal(String name) {
				this.name = name;
			}
		}

		public static class Dog extends Animal {

			public Dog(String name) {
				super(name);
			}
		}

		public static class Cat extends Animal {

			public Cat(String name) {
				super(name);
			}
		}

		private LinkedList<Animal> animalList = new LinkedList<Animal>();

		public void enqueue(Animal animal) {
			animalList.addLast(animal);
		}

		public Animal dequeueAny() {
			// return first in list
			return animalList.pollFirst();
		}

		public Dog dequeueDog() {
			for (Animal animal : animalList) {
				if (animal instanceof Dog) {
					animalList.remove(animal);
					return (Dog) animal;
				}
			}
			return null; // Not found
		}

		public Cat dequeueCat() {
			for (Animal animal : animalList) {
				if (animal instanceof Cat) {
					animalList.remove(animal);
					return (Cat) animal;
				}
			}
			return null; // Not found
		}
	}

	/*
	 * AFTER READING THE BOOK, they point out that keeping separate lists for
	 * dogs and cat reduces the time complexity. Just add comparator in Animal
	 * base class to determine which is 'older'. This does add more space
	 * complexity, but is negligible compared to the potential increased time
	 * complexity of my solution.
	 */
	
	@Override
	public BigO solutionTimeComplexity() {
		return BigO.CONSTANT; // If solution in book
	}
	
	@Override
	public BigO solutionSpaceComplexity() {
		return BigO.LINEAR;
	}
}
