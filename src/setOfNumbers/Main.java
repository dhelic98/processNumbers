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

		printStatus(listOfInts);
			


		} catch (Exception e) {
			System.out.println("Generic unexpected exception");
			main(args);

		}

	}

                private static void printStatus(ArrayList<Integer> list) {
		System.out.println("Status for input is:\nLowest number: " + minValue(list) + "\nLargest number: "
				+ maxValue(list) + "\nSum of numbers is: " + sumValues(list) + "\nAverage is: "
				+ getAverage(list) + "\nUnique numbers are: " + getUnique(list) + "\nList sorted: "
				+ getSortedList(list));

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
=======
	private static int minValue(ArrayList<Integer> list){
		int min = list.get(0);
		for(int i = 0; i < list.size(); i++){
			if(min > list.get(i)){
				min = list.get(i);
			}
		}
		return min;
	}
	
	private static int maxValue(ArrayList<Integer> list){
		int max = list.get(0);
		for(int i = 0; i < list.size(); i++){
			if(max < list.get(i)){
				max = list.get(i);
			}
		}
		return max;
	}
	
	private static int sumValues(ArrayList<Integer> list){
		int sum = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		return sum;

	}

}
