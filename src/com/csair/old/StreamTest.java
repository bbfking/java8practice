package com.csair.old;

import java.util.Arrays;
import java.util.List;

public class StreamTest {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("adf", "asdfadsf","as");
		int count = 0;
		for(String w : strs){
			if(w.length()>2){
				count++;
			}
		}
		System.out.println(count);
	}
}
