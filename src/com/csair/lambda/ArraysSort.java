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
			//调用父类的方法,可以不用实现Runable接口
			Thread t = new Thread(ConcurrentGreeter::new);
			t.start();
		}
		public void greet(){
			//调用父类的方法,可以不用实现Runable接口
			Thread t = new Thread(super::greet);
			t.start();
		}
	}
	public static void main(String[] args) {
		List<String> strs = Arrays.asList("AC", "C","BBBB");
		System.out.println(strs);
		strs.forEach(x->System.out.println(x+"1"));
		/**
		 * 函数式接口
		 * 函数式接口：只包含一个抽象方法的接口
		 * */
		//因为strs中已经指定了类型为String,所以fitst和second可以不用指定类型
		Collections.sort(strs,(first, second) -> Integer.compare(first.length(), second.length()));
		System.out.println(strs);
		
		/**
		 * 方法引用
		 * 对象::实例方法
		 * 类::静态方法
		 * 类::实例方法
		 * */
		Collections.sort(strs,String::compareTo);//等同于(x, y) -> x.compareTo(y)
		System.out.println(strs);
		
		ConcurrentGreeter childGreeter = new ConcurrentGreeter();
		//父类lambda
		childGreeter.greet();
		//构造方法lambda
		childGreeter.constructionLambda();
		testNewFeatureInterface();
	}
	/**
	 * 测试接口的一些新的特性，default,static
	 */
	public static void testNewFeatureInterface(){
		List<String> strs = Arrays.asList("A", "AC","ABC");
		//打印包含A字符的字条串？
		for (String str : strs) {
			System.out.println("字符串：" + str);
		}
		//forEach是Iterable的新方法default
		strs.forEach(x->System.out.println("字符串："+x));
		//comparing是Comparator的静态方法
		Collections.sort(strs, Comparator.comparing(String::length));
		System.out.println(strs);
	}
}
