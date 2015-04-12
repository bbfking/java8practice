package com.csair.old;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraysSort {
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("A", "C","B");
		System.out.println(strs);
		Collections.sort(strs,new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(strs);
	}
}
