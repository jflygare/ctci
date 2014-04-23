package chapter03;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import base.QuestionTestBase;

import chapter03.Question07.AnimalShelter;

public class Question07Test extends QuestionTestBase<Question07> {

	private AnimalShelter sut;

	@Before
	public void setUp() {
		setQuestionUnderTest(new Question07());
		sut = new AnimalShelter();
		sut.enqueue(new AnimalShelter.Dog("spot"));
		sut.enqueue(new AnimalShelter.Dog("spike"));
		sut.enqueue(new AnimalShelter.Cat("whiskers"));
		sut.enqueue(new AnimalShelter.Dog("Rex"));
		sut.enqueue(new AnimalShelter.Cat("Garfield"));
		sut.enqueue(new AnimalShelter.Cat("Felix"));
		sut.enqueue(new AnimalShelter.Dog("Duke"));
	}

	@Test
	public void test() {
		assertEquals("whiskers", sut.dequeueCat().getName());
		assertEquals("spot", sut.dequeueAny().getName());
		assertEquals("spike", sut.dequeueDog().getName());
	}

}
