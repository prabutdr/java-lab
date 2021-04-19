package com.prabutdr.dsa.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Heap<T extends Comparable<T>> {
	private final List<T> values;
	private HeapType type;
	
	enum HeapType {
		MIN_HEAP, MAX_HEAP;
	}

	private Heap() {
		this(HeapType.MAX_HEAP);
	}

	private Heap(HeapType type) {
		super();
		this.type = type;
		this.values = new ArrayList<>();
	}

	public int size() {
		return values.size();
	}
	
	private int leftIndex(int index) {
		int li = 2 * index + 1;
		if (li >= this.size()) {
			return -1;
		}
		return li;
	}
	
	private int rightIndex(int index) {
		int ri = 2 * index + 2;
		if (ri >= this.size()) {
			return -1;
		}
		return ri;
	}
	
	private int parentIndex(int index) {
		if (index <= 0 || index >= this.size()) {
			return -1;
		}
		return (index - 1) / 2;
	}
	
	private void perculateDown(int index) {
		int li = leftIndex(index);
		int targetIndex;
		
		if (li != -1 && compare(values.get(index), values.get(li)) < 0) {
			targetIndex = li;
		} else {
			targetIndex = index;
		}
		
		int ri = rightIndex(index);
		if (ri != -1 && compare(values.get(targetIndex), values.get(ri)) < 0) {
			targetIndex = ri;
		}
		
		if (index != targetIndex) {
			T temp = values.get(index);
			values.set(index, values.get(targetIndex));
			values.set(targetIndex, temp);
			perculateDown(targetIndex);
		}
	}
	
	private int compare(T value1, T value2) {
		return value1.compareTo(value2) * (HeapType.MIN_HEAP == type ? -1: 1);
	}
	
	public Optional<T> peek() {
		if (this.size() == 0) {
			return Optional.empty();
		}
		return Optional.of(values.get(0));
	}
	
	public void offer(T value) {
		values.add(value);
		
		int index = this.size() - 1;
		int parentIndex = parentIndex(index);
		while (parentIndex != -1 && compare(values.get(parentIndex), values.get(index)) < 0) {
			T temp = values.get(index);
			values.set(index, values.get(parentIndex));
			values.set(parentIndex, temp);
			
			index = parentIndex;
			parentIndex = parentIndex(index);
		}
	}
	
	public Optional<T> poll() {
		Optional<T> root = peek();
		if (!root.isEmpty()) {
			if (this.size() > 1) {
				this.values.set(0, this.values.get(this.size() - 1));
			}
			this.values.remove(this.size() - 1);
			if (this.size() > 1) {
				this.perculateDown(0);
			}
		}
		return root;
	}

	@Override
	public String toString() {
		return "Heap [values=" + values + "]";
	}
	
	@SafeVarargs
	public static <U extends Comparable<U>> Heap<U> build(HeapType type, U... elements) {
		Heap<U> heap = new Heap<>(type);
		heap.values.addAll(Arrays.asList(elements));
		for (int i = heap.size() / 2; i >= 0; i--) {
			heap.perculateDown(i);
		}
		return heap;
	}
	
}
