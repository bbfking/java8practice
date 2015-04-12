package com.csair.practice.chapter1;

/**
 * 
 * @author bbfking
 *
 */
public class UncheckTest {
	public static void main(String[] args) {
		new Thread(uncheck(() -> {
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

	public static Runnable uncheck(RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}
