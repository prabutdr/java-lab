package com.prabutdr.dsa.heaps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HeapSortTests {
	
	@ParameterizedTest
	@MethodSource
	public void sortShouldOrderElements(Integer[] values, Integer[] expectedValues) {
		HeapSort.sort(values);
		assertTrue(Arrays.equals(values, expectedValues));
	}
	
	public static Stream<Arguments> sortShouldOrderElements() {
		return Stream.of(
			Arguments.of(new Integer[] {10}, new Integer[] {10}),
			Arguments.of(new Integer[] {10, 5}, new Integer[] {5, 10}),
			Arguments.of(new Integer[] {10, 1, 5, 6}, new Integer[] {1, 5, 6, 10}),
			Arguments.of(new Integer[] {1, 2, 3, 4}, new Integer[] {1, 2, 3, 4}),
			Arguments.of(new Integer[] {4, 3, 2, 1}, new Integer[] {1, 2, 3, 4}),
			Arguments.of(new Integer[] {}, new Integer[] {})
		);
	}
}
