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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomQuickSortSeq {
	private static final Logger logger = LoggerFactory.getLogger(RandomQuickSortSeq.class);

	public static int arraySize = 0;
	public static int[] sequence = null;

	public static int swapPos = 0;

	public static void quickSort(int left, int right) {
		if (right - left <= 0) {
			
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
		if(sequence[dex1]>sequence[dex2]){
			swapPos++;
		}
		sequence[dex1] = sequence[dex2];
		sequence[dex2] = temp;

	}

	static void printSequence(int[] sorted_sequence) {
		for (int i = 0; i < sorted_sequence.length; i++)
			logger.info(sorted_sequence[i] + " ");
	}

	

	public static Map<String, Object> getSortedSequence(int[] sortedNumberArr) {
		sequence = sortedNumberArr;
		arraySize = sortedNumberArr.length;

		//printSequence(sequence);

		long startTime = System.nanoTime();

		quickSort(0, arraySize - 1);

		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		logger.info("\nSorted Sequence: ");
		logger.info("swapPos" + (swapPos - 1));
		logger.info("elapsedTime in nano " + elapsedTime);
		logger.info("elapsedTime in milli " + elapsedTime / 1000000);

		//printSequence(sequence);
		Map<String, Object> numberMap = new HashMap<String, Object>();

		numberMap.put("position", swapPos );
		numberMap.put("time", elapsedTime);
		String sortedSeq = Arrays.toString(sequence).replace("[", "")
				.replace("]", "");
		numberMap.put("sequence", sortedSeq);
		logger.info("sortedSeq " + sortedSeq);
		swapPos = 0;
		return numberMap;
	}
}
