package com.csair.practice.chapter3;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * using lambda for delay log
 * @author bbfking
 *
 */
public class DelayLog {
	enum Level{INFO,FINEST};
	public static void main(String[] args) {
		logIf(Level.FINEST,(i)->i==10, ()->"a[10] = " + 10);
	}
	public static void logIf(Level level, Predicate<Integer> predicate, Supplier<String> value){
		if(level == Level.FINEST){
			for(int i=0;i<20;i++){
				if(predicate.test(i)){
					System.out.println(value.get());
				}
			}
		}
	}
}
