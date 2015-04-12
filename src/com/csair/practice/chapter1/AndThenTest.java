package com.csair.practice.chapter1;

public class AndThenTest {

	public static void main(String[] args) {
		new Thread(andThen(() -> {
			System.out.println("Zzz");
		}, () -> {
			System.out.println("yyy");
		})).start();
	}

	public static Runnable andThen(Runnable ra, Runnable rb) {
		Runnable r = ()->{new Thread(ra).start();
		new Thread(rb).start();};
		return r;
	}
}
