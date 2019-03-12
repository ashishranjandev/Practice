package org.home.prac.design.flyweight;

public class FlyweightInventoryDemo {

	public static void main (String[] args) {
		InventorySystem ims =  new InventorySystem();
		
		ims.takeOrder("Roomba", 221);
		ims.takeOrder("Bose Headphone", 361);
		ims.takeOrder("Samsung TV", 933);
		ims.takeOrder("Samsung TV", 533);
		ims.takeOrder("Samsung TV", 833);
		ims.takeOrder("Roomba", 563);
		
		ims.process();
		
		System.out.println(ims.report());
	}
	
}
