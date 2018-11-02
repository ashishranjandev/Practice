package org.home.prac.waitnotify;

public class ProducerConsumer {

	private static int[] buffer;
	private static int count;
	private static Object lock = new Object();
	
	static class Producer {
		
		void produce() {
			synchronized (lock) {
				while(isFull(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				lock.notifyAll();
			}
		}
	}
	
	static class Consumer {
		
		void consume() {
			synchronized (lock) {
				while(isEmpty(buffer)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				lock.notifyAll();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		buffer = new int[50];
		count = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable produceTask = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i <50 ; i++) {
					producer.produce();
				}
				System.out.println("Done Producing");
			}
		};
		
		Runnable consumeTask = new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i <41 ; i++) {
					consumer.consume();
				}
				System.out.println("Done Consuming");
			}
		};
		
		Thread consumerThread = new Thread(consumeTask);
		Thread producerThread = new Thread(produceTask);
		
		consumerThread.start();
		producerThread.start();
		
		consumerThread.join();
		producerThread.join();
		
		System.out.println("Data in Buffer :"+count);
		
	}

	public static boolean isEmpty(int[] buffer2) {
		return count == 0;
	}

	public static boolean isFull(int[] buffer2) {
		return count == 50;
	}
}
