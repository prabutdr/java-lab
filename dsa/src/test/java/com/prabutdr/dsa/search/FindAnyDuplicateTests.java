package com.prabutdr.dsa.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class FindAnyDuplicateTests {
	
	@ParameterizedTest
	@MethodSource
	public void isAnyDuplicate_1(int[] array, boolean expected) {
		assertEquals(expected, FindAnyDuplicate.isAnyDuplicate_1(array));
	}
	
	public static Stream<Arguments> isAnyDuplicate_1() {
		return Stream.of(
				Arguments.of(new int[] {1, 2, 3, 1}, true),
				Arguments.of(new int[] {1, 2, 3, 1, 2, 3}, true),
				Arguments.of(new int[] {1, 2, 3}, false),
				Arguments.of(new int[] {}, false),
				Arguments.of(new int[] {1}, false)
		);
	}

	@ParameterizedTest
	@MethodSource
	public void isAnyDuplicate_2(int[] array, boolean expected) {
		assertEquals(expected, FindAnyDuplicate.isAnyDuplicate_2(array));
	}
	
	public static Stream<Arguments> isAnyDuplicate_2() {
		return isAnyDuplicate_1();
	}

	@ParameterizedTest
	@MethodSource
	public void isAnyDuplicate_3(int[] array, boolean expected) {
		assertEquals(expected, FindAnyDuplicate.isAnyDuplicate_3(array));
	}
	
	public static Stream<Arguments> isAnyDuplicate_3() {
		return isAnyDuplicate_1();
	}
}
