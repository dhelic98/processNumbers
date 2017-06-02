package setOfNumbers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	static Scanner uInput = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> listOfInts = new ArrayList<>();

		try {
			System.out.println("Please enter 10 whole numbers");

			for (int i = 0; i < 10; i++) {
				try {
					addNumbersToArray(listOfInts);
				} catch (InputMismatchException e) {
					System.out.println("Input exception.Input again");
					i--;
				} catch (NumberFormatException e) {
					System.out.println("Number format exception.Input again");
					i--;
				}
			}

			printStatus(listOfInts);

		} catch (Exception e) {
			System.out.println("Generic unexpected exception");
			main(args);

		}

	}

	private static void addNumbersToArray(ArrayList<Integer> list) {
		list.add(getNumberFromUser());

	}

	private static int getNumberFromUser() {
		return Integer.parseInt(uInput.nextLine().trim());
	}

	private static void printStatus(ArrayList<Integer> list) {
		System.out.println("Status for input is:\nLowest number: " + getLowestNumber(list) + "\nLargest number: "
				+ getLargestNumber(list) + "\nSum of numbers is: " + sumAllNumbers(list) + "\nAverage is: "
				+ getAverage(list) + "\nUnique numbers are: " + getUnique(list) + "\nList sorted: "
				+ getSortedList(list));

	}

	private static int getLowestNumber(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (min > list.get(i)) {
				min = list.get(i);
			}
		}

		return min;
	}

	private static int getLargestNumber(ArrayList<Integer> list) {
		int max = 0;

		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i)) {
				max = list.get(i);
			}
		}

		return max;

	}

	private static int sumAllNumbers(ArrayList<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}

		return sum;

	}

	private static double getAverage(ArrayList<Integer> list) {

		return sumAllNumbers(list) / 10.0;
	}

	private static String getUnique(ArrayList<Integer> list) {
		String uniqueNumbers = "";
		for (int i = 0; i < list.size(); i++) {
			if (isUnique(list, i, list.get(i))) {
				uniqueNumbers += list.get(i) + " ";
			}

		}
		return uniqueNumbers;

	}

	private static boolean isUnique(ArrayList<Integer> list, int index, int number) {
		for (int i = 0; i < list.size(); i++) {
			if (i == index) {
				continue;
			} else if (number == list.get(i)) {
				return false;
			}

		}

		return true;
	}

	private static String getSortedList(ArrayList<Integer> list) {
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				if (a > b) {
					return 1;
				} else if (b > a) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		String sorted = "";

		for (int i = 0; i < list.size(); i++) {
			sorted += list.get(i) + " ";
		}

		return sorted;
	}

}
