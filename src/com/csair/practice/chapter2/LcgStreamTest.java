package com.csair.practice.chapter2;

import java.util.stream.Stream;

/**
 * using lcg to generate 10 random
 * http://zh.wikipedia.org/wiki/%E7%B7%9A%E6%80%A7%E5%90%8C%E9%A4%98%E6%96%B9%E6%B3%95
 * @author bbfking
 *
 */
public class LcgStreamTest {
	public static void main(String[] args) {
		Stream<Long> stream = getLcgStream(25214903917L,11L,Math.round(Math.pow(2, 48)));
		stream.limit(10).forEach(System.out::println);
	}
	public static Stream<Long> getLcgStream(Long a, Long c , Long m){
		Stream<Long> longs = Stream.iterate(0L, n->(a*n+c)%m);
		return longs;
	}
}
