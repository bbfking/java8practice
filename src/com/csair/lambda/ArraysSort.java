package com.csair.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArraysSort {
	static class Greeter{
		public void greet(){
			System.out.println("Hello Greeter");
		}
	}
	static class ConcurrentGreeter extends Greeter{
		public ConcurrentGreeter(){
			System.out.println("Hello ConcurrentGreeter new");
		}
		public void constructionLambda(){
			//���ø���ķ���,���Բ���ʵ��Runable�ӿ�
			Thread t = new Thread(ConcurrentGreeter::new);
			t.start();
		}
		public void greet(){
			//���ø���ķ���,���Բ���ʵ��Runable�ӿ�
			Thread t = new Thread(super::greet);
			t.start();
		}
	}
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("AC", "C","BBBB");
		System.out.println(strs);
		strs.forEach(x->System.out.println(x+"1"));
		/**
		 * ����ʽ�ӿ�
		 * ����ʽ�ӿڣ�ֻ����һ�����󷽷��Ľӿ�
		 * */
		//��Ϊstrs���Ѿ�ָ��������ΪString,����fitst��second���Բ���ָ������
		Collections.sort(strs,(first, second) -> Integer.compare(first.length(), second.length()));
		System.out.println(strs);
		
		/**
		 * ��������
		 * ����::ʵ������
		 * ��::��̬����
		 * ��::ʵ������
		 * */
		Collections.sort(strs,String::compareTo);//��ͬ��(x, y) -> x.compareTo(y)
		System.out.println(strs);
		
		ConcurrentGreeter childGreeter = new ConcurrentGreeter();
		//����lambda
		childGreeter.greet();
		//���췽��lambda
		childGreeter.constructionLambda();
		testNewFeatureInterface();
	}
	/**
	 * ���Խӿڵ�һЩ�µ����ԣ�default,static
	 */
	public static void testNewFeatureInterface(){
		List<String> strs = Arrays.asList("A", "AC","ABC");
		//��ӡ����A�ַ�����������
		for (String str : strs) {
			System.out.println("�ַ�����" + str);
		}
		//forEach��Iterable���·���default
		strs.forEach(x->System.out.println("�ַ�����"+x));
		//comparing��Comparator�ľ�̬����
		Collections.sort(strs, Comparator.comparing(String::length));
		System.out.println(strs);
	}
}
