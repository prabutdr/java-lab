package com.prabutdr.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UnsortedSubArrayTests {
	
	@ParameterizedTest
	@MethodSource
	public void shouldReturnAppropriateStartAndEndIndex(int[] values, int[] expectedValues) {
		int[] result = UnsortedSubArray.findUnsortedPortion(values);
		assertEquals(expectedValues[0], result[0]);
		assertEquals(expectedValues[1], result[1]);
	}
	
	public static Stream<Arguments> shouldReturnAppropriateStartAndEndIndex() {
		return Stream.of( 
			Arguments.of(null, new int[] {0, 0}),
			Arguments.of(new int[] {}, new int[] {0, 0}),
			Arguments.of(new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}, new int[] {3, 8}),
			Arguments.of(new int[] {0, 1, 15, 25, 6, 7, 30, 40, 50}, new int[] {2, 5}),
			Arguments.of(new int[] {0, 1, 2, 3, 4}, new int[] {0, 0}),
			Arguments.of(new int[] {4, 3, 2, 1, 0}, new int[] {0, 4})
		);
	}
}
