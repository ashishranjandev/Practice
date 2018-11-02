package org.home.prac.java8;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException {
		//Anonymous Class
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Hello World from Thread[" + Thread.currentThread().getName() + "]");
				}
			}
		};
		
		// Lambda Expression
		Runnable runnableLambda = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello World from Thread[" + Thread.currentThread().getName() + "]");
			}
		};
		
		Thread t = new Thread(runnableLambda);
		//Thread t = new Thread(runnable);
		t.start();
		t.join();
	}
}
