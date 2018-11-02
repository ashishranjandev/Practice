package org.home.prac.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class ProducerConsumerWithLocks {
	
	public static final Integer MAX_SIZE = 50;

	public static void main(String[] args) throws InterruptedException {
		List<Integer> buffer = new ArrayList<>();
		Lock lock = new ReentrantLock();

		Condition isEmpty = lock.newCondition();
		Condition isFull = lock.newCondition();

		class Consumer implements Callable<String> {

			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 50) {
					lock.lock();
					while (isEmpty(buffer)) {
						// wait
						isEmpty.await(20, TimeUnit.MILLISECONDS);
					}
					buffer.remove(buffer.size() - 1);
					// signal
					isFull.signalAll();
					lock.unlock();
				}
				return "Consumed " + (count - 1);
			}

		}
		class Producer implements Callable<String> {

			@Override
			public String call() throws Exception {
				int count = 0;
				while (count++ < 50) {
					try {
						lock.lock();
						while (isFull(buffer)) {
							// wait
							isFull.await();
						}
						buffer.add(1);
						// signal
						isEmpty.signalAll();
					} finally {
						lock.unlock();
					}
				}
				return "Produced " + (count - 1);
			}
		}
		List<Producer> producers = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			producers.add(new Producer());
		}
		
		List<Consumer> consumers = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			consumers.add(new Consumer());
		}
		
		System.out.println("Producers and Consumers launced");
		
		List<Callable<String>> producersAndConsumers = new ArrayList<>();
		producersAndConsumers.addAll(producers);
		producersAndConsumers.addAll(consumers);
		
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		try {
			List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);
			
			futures.forEach(future -> {
				try {
					System.out.println(future.get());
				}catch(Exception e) {
					System.out.println("Exception "+e.getMessage());
				}
			});
		} finally {
			executorService.shutdown();
			System.out.println("Exceutor Service shut down.");
		}
	}

	public static boolean isEmpty(List<Integer> buffer) {
		if (buffer != null && buffer.size() > 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isFull(List<Integer> buffer) {
		if (buffer != null && buffer.size() == MAX_SIZE.intValue()) {
			return true;
		}
		return false;
	}
}
