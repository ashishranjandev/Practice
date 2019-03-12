package org.home.prac.design.flyweight;

public class Order {

	private final int orderNumber;
	private final Item item;
	
	public Order(int orderNumber, Item item) {
		super();
		this.orderNumber = orderNumber;
		this.item = item;
	}
	
	void processOrder() {
		System.out.println("Ordering Item : "+item+" for Order Number : "+orderNumber);
	}
	
}
