package com.csair.practice.time;

import java.time.LocalDate;

public class LocalDateTest {

	public static void main(String[] args) {
		/**
		 * ��LocalDate��plusYears����ʵ�֣�plusYears��һ��ʱ������
		 * resolvePreviousValid(2000+1, 2, 29)����ȥ����һ���µ�����
		 * resolvePreviousValid�ڹ���������ʱ�����ж������ڵĺϷ��ԣ�����2�·ݻ�ͨ�����·��������29������28
		 *  switch (month) {
         *   case 2:
         *      day = Math.min(day, IsoChronology.INSTANCE.isLeapYear(year) ? 29 : 28);
         *      break;
         * ��˼�һ��֮���� 2001-2-28
		 * */
		LocalDate date = LocalDate.of(2000, 2, 29).plusYears(1);
		System.out.println(date);
	}

}
