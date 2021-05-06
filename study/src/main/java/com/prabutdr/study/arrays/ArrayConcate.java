package com.prabutdr.study.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ArrayConcate {

	public static <T> T[] concateUsingCollections(T[] array1, T[] array2) {
		List<T> list = new ArrayList<>(array1.length + array2.length);
		Collections.addAll(list, array1);
		Collections.addAll(list, array2);
		
		@SuppressWarnings("unchecked")
		T[] resultArray = (T[]) Array.newInstance(array1.getClass().getComponentType(), 0);
		return list.toArray(resultArray);
	}

	public static <T> T[] concateUsingArrayCopy(T[] array1, T[] array2) {
		T[] resultArray = Arrays.copyOf(array1, array1.length + array2.length);
		System.arraycopy(array2, 0, resultArray, array1.length, array2.length);
		return resultArray;
	}
	
	public static <T> T concateForPrimitives(T array1, T array2) {
		if (!array1.getClass().isArray() || !array2.getClass().isArray()) {
			throw new IllegalArgumentException("Only arrays are accepted");
		}
		
		Class<?> compType1 = array1.getClass().getComponentType();
		Class<?> compType2 = array2.getClass().getComponentType();
		if (!compType1.equals(compType2)) {
			throw new IllegalArgumentException("Two arrays have different types");
		}
		
		int len1 = Array.getLength(array1);
		int len2 = Array.getLength(array2);
		
		@SuppressWarnings("unchecked")
		T result = (T) Array.newInstance(compType2, len1 + len2);
		
		System.arraycopy(array1, 0, result, 0, len1);
		System.arraycopy(array2, 0, result, len1, len2);
		
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] concateUsingStream(T[] array1, T[] array2) {
		return Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
			.toArray(size -> (T[]) Array.newInstance(array1.getClass().getComponentType(), size));
	}
	
}
