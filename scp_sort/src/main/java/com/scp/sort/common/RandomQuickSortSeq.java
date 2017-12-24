/**
 * 
 */
package com.scp.sort.common;

/**
 * @author Gokul
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomQuickSortSeq {
	public static int arraySize = 0;
	public static int[] sequence = null;

	public static int swapPos = 0;

	public static void quickSort(int left, int right) {
		if (right - left <= 0) {
			swapPos++;
			return;
		} else {
			Random rand = new Random();
			int pivotIndex = left + rand.nextInt(right - left + 1);
			swap(pivotIndex, right);

			int pivot = sequence[right];
			int partition = partitionIt(left, right, pivot);
			quickSort(left, partition - 1);
			quickSort(partition + 1, right);
		}
	}

	public static int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (sequence[++leftPtr] < pivot)
				;
			while (rightPtr > 0 && sequence[--rightPtr] > pivot)
				;

			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr;
	}

	public static void swap(int dex1, int dex2) {
		int temp = sequence[dex1];
		sequence[dex1] = sequence[dex2];
		sequence[dex2] = temp;

	}

	static void printSequence(int[] sorted_sequence) {
		for (int i = 0; i < sorted_sequence.length; i++)
			System.out.print(sorted_sequence[i] + " ");
	}

	/*
	 * public static void main(String args[]) { String inputNumbers =
	 * "12,3,45,4,89,78,2"; String [] inputNumberArray =
	 * inputNumbers.split(","); int[] intArray = new
	 * int[inputNumberArray.length]; for(int i = 0; i < inputNumberArray.length;
	 * i++) { intArray[i] = Integer.parseInt(inputNumberArray[i]); }
	 * getSortedSequence(intArray); }
	 */

	public static Map<String, Object> getSortedSequence(int[] sortedNumberArr) {
		sequence = sortedNumberArr;
		arraySize = sortedNumberArr.length;

		System.out.println("\nOriginal Sequence: ");
		printSequence(sequence);

		long startTime = System.nanoTime();

		quickSort(0, arraySize - 1);

		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("\nSorted Sequence: ");
		System.out.println("swapPos" + (swapPos - 1));
		System.out.println("elapsedTime in nano " + elapsedTime);
		System.out.println("elapsedTime in milli " + elapsedTime / 1000000);

		printSequence(sequence);
		Map<String, Object> numberMap = new HashMap<String, Object>();

		numberMap.put("position", (swapPos - 1));
		numberMap.put("time", elapsedTime / 1000000);
		String sortedSeq = Arrays.toString(sequence).replace("[", "")
				.replace("]", "");
		numberMap.put("sequence", sortedSeq);
		System.out.println("sortedSeq " + sortedSeq);
		swapPos = 0;
		return numberMap;
	}
}
