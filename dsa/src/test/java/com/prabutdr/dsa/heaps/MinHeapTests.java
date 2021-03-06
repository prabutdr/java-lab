package com.prabutdr.dsa.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.prabutdr.dsa.heaps.Heap.HeapType;

@SpringBootTest
public class MinHeapTests {
	
	@ParameterizedTest
	@MethodSource
	public void peekShouldReturnMinOnMinHeap(Integer[] values, Integer expectedPeek) {
		Heap<Integer> heap = Heap.build(HeapType.MIN_HEAP, values);
		assertEquals(expectedPeek, heap.peek().orElse(null));
	}
	
	private static Stream<Arguments> peekShouldReturnMinOnMinHeap() {
		return Stream.of(
			Arguments.of(new Integer[] {}, null),
			Arguments.of(new Integer[] {10}, 10),
			Arguments.of(new Integer[] {10, 20}, 10),
			Arguments.of(new Integer[] {5, 10, 20}, 5),
			Arguments.of(new Integer[] {30, 20, 10}, 10)
		);
	}
	
	@ParameterizedTest
	@MethodSource
	public void pollShouldReturnNextMinEachTimeOnMinHeap(Integer[] values, Integer[] pollValues) {
		Heap<Integer> heap = Heap.build(HeapType.MIN_HEAP, values);
		for (Integer pollValue: pollValues) {
			assertEquals(pollValue, heap.poll().get());
		}
		assertNull(heap.poll().orElse(null));  // on empty heap
	}
	
	private static Stream<Arguments> pollShouldReturnNextMinEachTimeOnMinHeap() {
		return Stream.of(
			Arguments.of(new Integer[] {10}, new Integer[] {10}),
			Arguments.of(new Integer[] {10, 20}, new Integer[] {10, 20}),
			Arguments.of(new Integer[] {5, 10, 20}, new Integer[] {5, 10, 20}),
			Arguments.of(new Integer[] {30, 20, 10}, new Integer[] {10, 20, 30})
		);
	}
	
	@ParameterizedTest
	@MethodSource
	public void offerOnMinHeap(Integer[][] offerPeakValuePairs) {
		Heap<Integer> heap = Heap.build(HeapType.MIN_HEAP);
		assertNull(heap.poll().orElse(null));  // on empty heap
		for (Integer[] offerPeakValuePair: offerPeakValuePairs) {
			heap.offer(offerPeakValuePair[0]);
			assertEquals(offerPeakValuePair[1], heap.peek().get());
		}
	}
	
	private static Stream<Arguments> offerOnMinHeap() {
		return Stream.of(
			Arguments.of((Object)new Integer[][] {{10, 10}}),
			Arguments.of((Object)new Integer[][] {{10, 10}, {20, 10}}),
			Arguments.of((Object)new Integer[][] {{5, 5}, {10, 5}, {20, 5}, {3, 3}}),
			Arguments.of((Object)new Integer[][] {{30, 30}, {20, 20}, {10, 10}})
		);
	}
	
	@ParameterizedTest
	@MethodSource
	public void findMaxShouldReturnMaxValue(Integer[] values, Integer expectedMax) {
		Heap<Integer> heap = Heap.build(HeapType.MIN_HEAP, values);
		assertEquals(expectedMax, heap.findMax().orElse(null));
	}

	private static Stream<Arguments> findMaxShouldReturnMaxValue() {
		return Stream.of(
			Arguments.of(new Integer[] {}, null),
			Arguments.of(new Integer[] {10}, 10),
			Arguments.of(new Integer[] {10, 20}, 20),
			Arguments.of(new Integer[] {5, 10, 20}, 20),
			Arguments.of(new Integer[] {30, 20, 10}, 30),
			Arguments.of(new Integer[] {30, 20, 10, 35}, 35)
		);
	}
}
