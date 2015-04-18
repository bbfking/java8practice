package com.csair.practice.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

/**
 * input Predicate<LoacalDate> return a TemporalAdjuster
 * the TemporalAdjuster can get the date of pass predicate test
 * @author bbfking
 *
 */
public class PredicateNext {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today.with(next(w->Month.FEBRUARY.equals(w.getMonth()))));
	}
	public static TemporalAdjuster next(Predicate<LocalDate> pld){
		return w->{
			LocalDate result = (LocalDate) w;
			do{
				result = result.plusDays(1);
			}while(!pld.test(result));
			return result;
		};
	}
		
}
