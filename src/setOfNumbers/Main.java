package setOfNumbers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

			System.out.println(prosjekBrojeva(listOfInts));

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

	private static double prosjekBrojeva(ArrayList<Integer> list) {
		long sum = 0;
		int count = 0;
		for (int element : list) {
			sum += element;
		}
		count = list.size();
		if (count == 0)
			return 0;
		return sum * 1.0 / count;
	}

	private static String getUnique(ArrayList<Integer> list) {
		List<Integer> listDistinct = list.stream().distinct().collect(Collectors.toList());
		return listDistinct.toString();
	}

	private static String sortArray(ArrayList<Integer> list) {
		list.sort(null);
		return list.toString();
	}

}
