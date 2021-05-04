package com.prabutdr.study.maths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GCDTests {

	@ParameterizedTest
	@MethodSource
	public void gcdUsingBigInteger(int a, int b, int expectedGcd) {
		assertEquals(expectedGcd, GCD.gcdUsingBigInteger(a, b));
	}
	
	public static Stream<Arguments> gcdUsingBigInteger() {
		return Stream.of(
				Arguments.of(15, 5, 5),
				Arguments.of(15, 18, 3),
				Arguments.of(15, 0, 15),
				Arguments.of(0, 0, 0),
				Arguments.of(15, 1, 1)
		);
	}

	@ParameterizedTest
	@MethodSource
	public void gcdUsingRecursion(int a, int b, int expectedGcd) {
		assertEquals(expectedGcd, GCD.gcdUsingRecursion(a, b));
	}
	
	public static Stream<Arguments> gcdUsingRecursion() {
		return gcdUsingBigInteger();
	}
}
