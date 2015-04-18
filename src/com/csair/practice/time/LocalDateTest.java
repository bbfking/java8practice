package com.csair.practice.time;

import java.time.LocalDate;

public class LocalDateTest {

	public static void main(String[] args) {
		/**
		 * 见LocalDate的plusYears方法实现，plusYears加一年时，调用
		 * resolvePreviousValid(2000+1, 2, 29)方法去构造一个新的日期
		 * resolvePreviousValid在构造新日期时，会判断新日期的合法性，对于2月份会通过以下方法解决是29，还是28
		 *  switch (month) {
         *   case 2:
         *      day = Math.min(day, IsoChronology.INSTANCE.isLeapYear(year) ? 29 : 28);
         *      break;
         * 因此加一年之后是 2001-2-28
		 * */
		LocalDate date = LocalDate.of(2000, 2, 29).plusYears(1);
		System.out.println(date);
	}

}
