package com.prabutdr.dsa.heaps;

import com.prabutdr.dsa.heaps.Heap.HeapType;

public class HeapSort {
	public static <T extends Comparable<T>> void sort(T[] values) {
		Heap<T> heap = Heap.build(HeapType.MIN_HEAP, values);
		
		for (int i = 0; i < values.length; i++) {
			values[i] = heap.poll().get();
		}
	}
}
