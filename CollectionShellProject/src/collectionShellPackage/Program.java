package collectionShellPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Program {
	// To do: Follow the instructions in the assignment, replace all the "to do"
	// comments accordingly.
	public static void main(String[] args) throws Exception {
		int[] baseArray = { 1, 3, 3, 4, 5 };
		String[] baseStringsarray = { "One", "Three", "Four", "Five" };
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String svar = "";

		do {
			System.out.println(
					"\n1. Plocka ut samtliga dubletter - Array\n2. Plocka ut samtliga dubletter - Set\n3. Lägg till värde i slutet på array - List\n4. Plocka bort värde ur array och krym den\n5. Merga int- och String- arrayer till en Map\n0. Avsluta");
			try {
				svar = inputReader.readLine();
			} catch (IOException ioem) {
				ioem.printStackTrace();
				System.out.println("Ooops, tyvärr ... vid Val ");
			}

			// 0 To do: Menu Replace the content of this method, below this
			// comment
			// with a menu-system
			// navigating to all the different methods below.

			switch (svar) {
			case "1":

				for (int i : baseArray) {
					System.out.println(i);
				}
				System.out.println("Duplicates Above-------------No Duplicates Below");
				baseArray = removeDuplicates(baseArray);
				for (int i : baseArray) {
					System.out.println(i);
				}

			case "2":

				for (int i : baseArray) {
					System.out.println(i);
				}
				System.out.println("Duplicates Above-------------No Duplicates Below");
				baseArray = removeDuplicatesSet(baseArray);
				for (int i : baseArray) {
					System.out.println(i);
				}
			case "3":
				for (int i : baseArray) {
					System.out.println(i);
				}
				System.out.println("Duplicates Above-------------No Duplicates Below");
				baseArray = expandableAdd(baseArray, 0);
				for (int i : baseArray) {
					System.out.println(i);
				}
			case "4":

				for (int i : baseArray) {
					System.out.println(i);
				}
				System.out.println("Duplicates Above-------------No Duplicates Below");
				baseArray = shrinkingRemove(baseArray, 0);
				for (int i : baseArray) {
					System.out.println(i);
				}
			case "5":

				for (int i : baseArray) {
					System.out.println(i);
				}
				System.out.println("Duplicates Above-------------No Duplicates Below");
				baseArray = mergeIntAndStringArrays(baseArray, 0);
				for (int i : baseArray) {
					System.out.println(i);
				}
			case "0":
			default:
				break;
			}
		} while (!svar.equals("0"));
		System.out.println("Avslut!");
	}

	// 1 This method removes any duplicate values from an inputed array of
	// Integers.
	private static int[] removeDuplicates(int[] arrayWithDuplicates) {
		int[] arrayWithoutDuplicates = new int[0];
		for (int i = 0; i < arrayWithDuplicates.length; i++) {
			int current = arrayWithDuplicates[i];
			boolean exists = false;
			for (int j = 0; j < arrayWithoutDuplicates.length; j++) {
				if (current == arrayWithoutDuplicates[j]) {
					exists = true;
				}
			}
			if (!exists) {
				int[] temp = new int[arrayWithoutDuplicates.length + 1];
				System.arraycopy(arrayWithoutDuplicates, 0, temp, 0, arrayWithoutDuplicates.length);
				temp[arrayWithoutDuplicates.length] = current;
				arrayWithoutDuplicates = temp;
			}
		}
		return arrayWithoutDuplicates;
	}

	// This method removes any duplicate values from an inputed array of
	// integers using a Set
	private static int[] removeDuplicatesSet(int[] arrayWithDuplicates) {
		int[] arrayWithoutDuplicates = new int[0];
		Set<Integer> myset = new HashSet<Integer>();
		for (int i =0; i<=arrayWithDuplicates.length; i++){
			myset.add(new Integer(arrayWithoutDuplicates[i]));
		}				
		return arrayWithoutDuplicates;
		
		// 2 To do: Replace the code in this method, to remove any duplicates
		// from an array and shrink it.
		// Use the collection type "Set" to remove the duplicates.
//		throw new java.lang.UnsupportedOperationException();
	}

	private static int[] expandableAdd(int[] targetArray, int value) {
		// 3 To do: Replace the code in this method to add the int "value" to
		// the end of "targetArray".
		// Use the collection type "List" to do this.
		throw new java.lang.UnsupportedOperationException();
	}

	private static int[] shrinkingRemove(int[] targetArray, int value) {
		// 4 To do: Replace the code in this method to remove the int "value"
		// from "targetArray" and shrink it's size.
		// Use the collection type "List" to do this.
		throw new java.lang.UnsupportedOperationException();
	}

	private static int[] mergeIntAndStringArrays(int[] targetArray, int value) {
		// 4 To do: Replace the code in this method to remove the int "value"
		// from "targetArray" and shrink it's size.
		// Use the collection type "List" to do this.
		throw new java.lang.UnsupportedOperationException();
	
	// 5 To do: Create the method "Combine arrays" that has the following
	// function:
	// Input: int[] Keys, String[] Values. The Keys array may not contain
	// duplicates.
	// Output: A map, using the values from Keys as keys, and values from Values
	// as values.
	// Explanation: Given two arrays, one of integers and the other of strings,
	// both the same lengths
	// creates a map containing the integers as keys, and the strings as values.

	// Generic To do:
	// Change all the methods above to work for arrays no matter which type they
	// contain.
	// In other words, allow the above methods to work with generic arrays.

	}}
