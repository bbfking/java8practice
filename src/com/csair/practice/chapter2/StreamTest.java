package com.csair.practice.chapter2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		int[] values = {1,4,9,16};
		Stream stream = Stream.of(values);
		IntStream intStream = IntStream.of(values);
	}
}
