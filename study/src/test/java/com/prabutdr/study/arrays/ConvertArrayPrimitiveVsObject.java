package com.prabutdr.study.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConvertArrayPrimitiveVsObject {

	@Test
	public void convertPrimitiveToObjectWithStream() {
		int[] input = new int[] {1, 2, 3, 40};
		Integer[] expected = new Integer[] {1, 2, 3, 40};
		
		Integer[] output = Arrays.stream(input).boxed().toArray(Integer[]::new);
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void convertObjectToPrimitiveWithStream() {
		Integer[] input = new Integer[] {1, 2, 3, 40};
		int[] expected = new int[] {1, 2, 3, 40};
		
		int[] output = Arrays.stream(input).mapToInt(Integer::valueOf).toArray();
		assertArrayEquals(expected, output);
	}

	@Test
	public void convertPrimitiveToObjectWithApacheCommons() {
		int[] input = new int[] {1, 2, 3, 40};
		Integer[] expected = new Integer[] {1, 2, 3, 40};
		
		Integer[] output = ArrayUtils.toObject(input);
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void convertObjectToPrimitiveWithApacheCommons() {
		Integer[] input = new Integer[] {1, 2, 3, 40};
		int[] expected = new int[] {1, 2, 3, 40};
		
		int[] output = ArrayUtils.toPrimitive(input);
		assertArrayEquals(expected, output);
	}
}
