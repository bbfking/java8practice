package com.csair.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamTest {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("adf", "asdfadsf","as");
		long count = strs.parallelStream().filter(w -> w.length() > 2).count();
		System.out.println(count);
		Optional<String> fa = strs.stream().filter(w->w.contains("fa")).findAny();
		if(fa.isPresent()){
			System.out.println(fa.get());
		}
		
		int result = strs.stream().reduce(-0,(total, word) -> total + word.length(), (total1, total2) -> total1 + total2);
		System.out.println(result);
	}
}
