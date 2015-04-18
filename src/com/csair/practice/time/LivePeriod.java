package com.csair.practice.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LivePeriod {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(1987, 9, 6);
		LocalDate now = LocalDate.now();
		System.out.println("已经活了："+ld.until(now, ChronoUnit.DAYS)+"天");
	}
}
