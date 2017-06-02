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
