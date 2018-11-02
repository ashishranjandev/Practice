package org.home.prac.runnable;

public class FirstRunnable {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				System.out.println("I'm running in "+threadName);
			}};
			
			Thread thread = new Thread(runnable);
			thread.setName("My Thread");
			thread.start();
			//thread.run(); -- No
	}
}
