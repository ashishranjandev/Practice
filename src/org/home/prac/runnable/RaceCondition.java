package org.home.prac.runnable;

import org.home.prac.runnable.model.LongWrapper;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {
		
		LongWrapper lw = new LongWrapper(0L);

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for(int i=0; i < 1000; i++) {
					lw.incrementValue();
				}
			}};
			
			Thread[] threads = new Thread[1000];
			for(int i=0; i < threads.length; i++) {
				threads[i] = new Thread(runnable);
				threads[i].start();
			}
			
			for(int i=0; i < threads.length; i++) {
				threads[i].join();
			}
	
			System.out.println("Value -- "+lw.getL());
	}
}
