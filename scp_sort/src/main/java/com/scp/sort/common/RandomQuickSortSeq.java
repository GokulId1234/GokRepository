/**
 * 
 */
package com.scp.sort.common;

/**
 * @author Gokul
 * To perform  sort based upon random sort algorithm
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomQuickSortSeq {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RandomQuickSortSeq.class);

	public static int arraySize = 0;
	public static int[] sequence = null;
	public static int swapPos = 0;

	/**
	 * Method to sort numbers based upon indexes
	 * @param left
	 * @param right
	 */
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

	/**
	 * Method to perform partitions based upon indexes
	 * @param left
	 * @param right
	 * @param pivot
	 * @return
	 */
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

	/**
	 * Method to swap numbers in respective index positions
	 * @param dex1
	 * @param dex2
	 */
	public static void swap(int dex1, int dex2) {
		int temp = sequence[dex1];
		if (sequence[dex1] > sequence[dex2]) {
			swapPos++;
		}
		sequence[dex1] = sequence[dex2];
		sequence[dex2] = temp;

	}
	
	/**
	 * Method to print int in int array
	 * @param sorted_sequence
	 */

	static void printSequence(int[] sorted_sequence) {
		for (int i = 0; i < sorted_sequence.length; i++)
			logger.info(sorted_sequence[i] + " ");
	}
	
	/**
	 * Method to perform sort based upon int array elements
	 * @param sortedNumberArr
	 * @return
	 */

	public static Map<String, Object> getSortedSequence(int[] sortedNumberArr) {
		
		sequence = sortedNumberArr;
		arraySize = sortedNumberArr.length;
		// printSequence(sequence);
		long startTime = System.nanoTime();
		quickSort(0, arraySize - 1);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		logger.info("\nSorted Sequence: ");
		logger.info("swapPos" + (swapPos - 1));
		logger.info("elapsedTime in nano " + elapsedTime);
		logger.info("elapsedTime in milli " + elapsedTime / 1000000);
		// printSequence(sequence);
		Map<String, Object> numberMap = new HashMap<String, Object>();
		numberMap.put(ConstantsUtil.STR_POSITION, (swapPos - 1));
		numberMap.put(ConstantsUtil.STR_TIME, elapsedTime);
		String sortedSeq = Arrays.toString(sequence).replace(ConstantsUtil.LEFT_BRACKET, ConstantsUtil.NULL_STRING)
				.replace(ConstantsUtil.RIGHT_BRACKET, ConstantsUtil.NULL_STRING);
		numberMap.put(ConstantsUtil.STR_SEQUENCE, sortedSeq);
		logger.info("sortedSeq " + sortedSeq);
		swapPos = 0;
		return numberMap;
	}
}
