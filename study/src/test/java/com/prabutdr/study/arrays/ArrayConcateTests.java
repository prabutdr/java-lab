package com.prabutdr.study.arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
	
	
}
