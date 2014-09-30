package com.polymathiccoder.talk.debug.exercise1;

import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.util.Random;

public class RandomNumbers {
	private final int[] numbers;

	public RandomNumbers() {
		final Random random = new Random();
		final int numberOfRandomNumbers = random.nextInt(5) + 5;

		numbers = new int[numberOfRandomNumbers];
		for (int i = 0; i < numberOfRandomNumbers; i++) {
			numbers[i] = random.nextInt(100);
		}
	}

	public int sum() {
		int sum = 0;
		for (final int n : numbers) {
			sum += n;
		}
		return sum;
	}

	public void sort() {
		bubbleSort(numbers, 0, numbers.length - 1);
	}

	public void prettyPrint() {
		final String prettyRandomNumbers = join(", ", stream(numbers).mapToObj(Integer::toString).collect(toList()));
		System.out.println("Pretty random numbers: " + prettyRandomNumbers);
	}

	private static void bubbleSort(int[] numbers, int first, int last) {
		if (first < last && last > 0) {
			if (numbers[first] > numbers[first + 1]) {
				int temp = numbers[first];
				numbers[first] = numbers[first + 1];
				numbers[first + 1] = temp;
			}
			bubbleSort(numbers, first + 1, last);
			bubbleSort(numbers, first, last - 1);
		}
	}
}