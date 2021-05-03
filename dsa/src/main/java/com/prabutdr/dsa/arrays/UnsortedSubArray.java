package com.prabutdr.dsa.arrays;

public class UnsortedSubArray {
	// [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60]
	public static int[] findUnsortedPortion(int[] array) {
		if (array == null || array.length < 2) {
			return new int[] {0, 0};
		}
		
		int startIdx;
		for (startIdx = 0; startIdx < array.length - 1; startIdx++) {
			if (array[startIdx] > array[startIdx + 1]) {
				startIdx++;
				break;
			}
		}

		int endIdx;
		for (endIdx = array.length - 1; endIdx > 0; endIdx--) {
			if (array[endIdx] < array[endIdx - 1]) {
				endIdx--;
				break;
			}
		}
		
		int min = array[startIdx];
		int max = array[endIdx];
		for (int i = startIdx; i <= endIdx; i++) {
			if (min > array[i]) {
				min = array[i];
			} else if (max < array[i]) {
				max = array[i];
			}
		}
		
		for (; startIdx > 0; startIdx--) {
			if (array[startIdx - 1] < min) {
				break;
			}
		}
		
		for (; endIdx < array.length - 1; endIdx++) {
			if (array[endIdx + 1] > max) {
				break;
			}
		}
		
		return (endIdx < startIdx)? new int[] {0, 0}: new int[] {startIdx, endIdx};
	}
}
