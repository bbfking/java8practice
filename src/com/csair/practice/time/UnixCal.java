package com.csair.practice.time;

import java.time.LocalDate;

/**
 * unix cal命令功能程序
 * java UnixCal 3 2013 ->
 *             1  2  3 
 * 4  5  6  7  8  9  10
 * 11 12 13 14 15 16 17
 * 18 19 20 21 22 23 24
 * 25 26 27 28 29 30 31
 * @author bbfking
 *
 */
public class UnixCal {

	public static void main(String[] args) {
		if(args != null && args.length == 2){
			int year = Integer.valueOf(args[1]);
			int month = Integer.valueOf(args[0]);
			LocalDate ld = LocalDate.of(year, month, 1);
			int printCol = 0;//打印指针，打印一次，printCol加一
			int curCol;//当前星期打印的位置
			while(ld.getMonthValue() == month){
				curCol = (ld.getDayOfWeek().getValue())*2-2;
				while(printCol != curCol){
					if(printCol<12){
						String blank = (printCol+2)%2 == 0 ? "  " : " ";
						System.out.print(blank);
						printCol ++;
					}else{
						printCol = 0;
						System.out.println("");
					}
				}
				//打印一次，printCol加一
				printCol ++;
				String dom = ld.getDayOfMonth() + "";
				//为了对齐，如果是一位数的日期则多补一个空格
				dom = dom.length()<2 ? (dom+" ") : dom;
				System.out.print(dom);
				ld = ld.plusDays(1);
			}
			
			
		}

	}

}
