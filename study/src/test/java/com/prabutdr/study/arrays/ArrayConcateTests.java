package com.prabutdr.study.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArrayConcateTests {

	@ParameterizedTest
	@MethodSource
	public void concateShouldCombineArraysUsingCollections(Integer[] array1, Integer[] array2, Integer[] expectedArray) {
		Integer[] result = ArrayConcate.concateUsingCollections(array1, array2);
		assertThat(result).isEqualTo(expectedArray);
	}
	
	public static Stream<Arguments> concateShouldCombineArraysUsingCollections() {
		return Stream.of(
			Arguments.of(new Integer[] {3}, new Integer[] {4}, new Integer[] {3, 4}),
			Arguments.of(new Integer[] {}, new Integer[] {}, new Integer[] {})
		);
	}
	
	@ParameterizedTest
	@MethodSource
	public void concateShouldCombineArraysUsingArrayCopy(Integer[] array1, Integer[] array2, Integer[] expectedArray) {
		Integer[] result = ArrayConcate.concateUsingArrayCopy(array1, array2);
		assertThat(result).isEqualTo(expectedArray);
	}
	
	public static Stream<Arguments> concateShouldCombineArraysUsingArrayCopy() {
		return concateShouldCombineArraysUsingCollections();
	}
	
	@ParameterizedTest
	@MethodSource
	public void concateForPrimitives(int[] array1, int[] array2, int[] expectedArray) {
		int[] result = ArrayConcate.concateForPrimitives(array1, array2);
		assertThat(result).isEqualTo(expectedArray);
	}
	
	public static Stream<Arguments> concateForPrimitives() {
		return Stream.of(
				Arguments.of(new int[] {3}, new int[] {4}, new int[] {3, 4}),
				Arguments.of(new int[] {}, new int[] {}, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource
	public void concateForPrimitivesWithInvalidInputs(Object array1, Object array2) {
		assertThrows(IllegalArgumentException.class, () -> ArrayConcate.concateForPrimitives(array1, array2));
	}
	
	public static Stream<Arguments> concateForPrimitivesWithInvalidInputs() {
		return Stream.of(
				Arguments.of("abc", new int[] {4}, new int[] {3, 4}),
				Arguments.of(new int[] {}, new float[] {}, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource
	public void concateShouldCombineArraysUsingStream(Integer[] array1, Integer[] array2, Integer[] expectedArray) {
		Integer[] result = ArrayConcate.concateUsingArrayCopy(array1, array2);
		assertThat(result).isEqualTo(expectedArray);
	}
	
	public static Stream<Arguments> concateShouldCombineArraysUsingStream() {
		return concateShouldCombineArraysUsingCollections();
	}
	
	
}
