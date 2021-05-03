package com.prabutdr.study.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
}
