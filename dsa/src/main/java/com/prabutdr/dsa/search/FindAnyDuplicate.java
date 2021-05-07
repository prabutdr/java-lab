package com.prabutdr.dsa.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindAnyDuplicate {

	// O(n^2)
	public static boolean isAnyDuplicate_1(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	// O(n*log(n)) - using sort
	public static boolean isAnyDuplicate_2(int[] array) {
		Arrays.sort(array);
		
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				return true;
			}
		}
		return false;
	}

	// O(n) - Using hash with additional space
	public static boolean isAnyDuplicate_3(int[] array) {
		Set<Integer> set = new HashSet<>(); 
		
		for (int i = 0; i < array.length; i++) {
			if (!set.add(array[i])) {
				return true;
			}
		}
		return false;
	}
}
