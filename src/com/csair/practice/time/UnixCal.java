package com.csair.practice.time;

import java.time.LocalDate;

/**
 * unix cal����ܳ���
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
			int printCol = 0;//��ӡָ�룬��ӡһ�Σ�printCol��һ
			int curCol;//��ǰ���ڴ�ӡ��λ��
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
				//��ӡһ�Σ�printCol��һ
				printCol ++;
				String dom = ld.getDayOfMonth() + "";
				//Ϊ�˶��룬�����һλ����������ಹһ���ո�
				dom = dom.length()<2 ? (dom+" ") : dom;
				System.out.print(dom);
				ld = ld.plusDays(1);
			}
			
			
		}

	}

}
