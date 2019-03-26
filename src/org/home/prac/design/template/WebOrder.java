package org.home.prac.design.template;

public class WebOrder extends OrderTemplate {

	@Override
	public void doCheckout() {
		System.out.println("Get items from Cart.");
		System.out.println("Set Gift Preferece.");
		System.out.println("Set Delivery Address.");
		System.out.println("Set Billing Address.");
	}

	@Override
	public void doPayment() {
		System.out.println("Process payment with Card.");
	}

	@Override
	public void doReceipt() {
		System.out.println("Email the receipt");
	}

	@Override
	public void doDelivery() {
		System.out.println("Send the items to address.");
	}

}
