package org.home.prac.excecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorsDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		//threadsVsExcectors();
		callableDemo();
	}
	
	private static void callableDemo() throws InterruptedException, ExecutionException, TimeoutException {
		Callable<String> task1 = () -> {
			Thread.sleep(20);
			return "I am in Thread" + Thread.currentThread().getName();
		};
		Callable<String> task2 = () -> {
			throw new IllegalStateException("I throw an exception in Thread " + Thread.currentThread().getName());
		};
		ExecutorService service = Executors.newFixedThreadPool(4);
		
		try {
			for(int i = 0; i < 10; i++) {
				//new Thread(task).start();
				Future<String> future = service.submit(task1);
				//Future<String> future = service.submit(task2);
				System.out.println("I got "+future.get(100, TimeUnit.MILLISECONDS));
			}
		} finally {
			//If we don't add this code, JVM will be alive
			// As it keeps non-daemon threads alive
			service.shutdown();
		}
	}
	
	@SuppressWarnings("unused")
	private static void threadsVsExcectors() {
		Runnable task = () -> System.out.println("I am in Thread" + Thread.currentThread().getName());
		
		ExecutorService service = null;
		//service = Executors.newSingleThreadExecutor();
		service = Executors.newFixedThreadPool(4);
		
		for(int i = 0; i < 10; i++) {
			//new Thread(task).start();
			service.execute(task);
		}
		
		//If we don't add this code, JVM will be alive
		// As it keeps non-daemon threads alive
		service.shutdown();
	}
}
