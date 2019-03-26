package org.home.prac.design.visitor;

public class AtvPartsShippingVisitor implements AtvPartVisitor {

	double shippingAmount = 0;
	
	@Override
	public void visit(Oil oil) {
		System.out.println("Oil is tedious to ship");
		shippingAmount+=9;
	}

	@Override
	public void visit(Fender fender) {
		System.out.println("Fender is easier to ship");
		shippingAmount+=3;
	}

	@Override
	public void visit(Wheel wheel) {
		System.out.println("Wheels are bulky and harder to ship");
		shippingAmount+=15;
	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("For size of order more than 3, there is a shipping discount");
		if(partsOrder.getParts().size() >= 3) {
			shippingAmount-=5;
		}
		System.out.println("Shipping amount is "+ shippingAmount);
	}

}
