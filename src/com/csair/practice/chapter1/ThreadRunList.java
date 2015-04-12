package com.csair.practice.chapter1;

import java.util.ArrayList;
import java.util.List;

public class ThreadRunList {
	public static void main(String[] args) {
		String[] names = {"aa","bb","cc"};
		List<Runnable> runners = new ArrayList<>();
		for(int i=0; i< names.length; i++){
			String a = names[i];//闭包中的自由变量
			runners.add(() -> System.out.println(a));
		}
		for(Runnable r : runners){
			new Thread(r).start();
		}
	}
}
