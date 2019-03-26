package org.home.prac.design.visitor;

public class VisitorDemo {

	public static void main(String[] args) {
		PartsOrder partsOrder = new PartsOrder();
		partsOrder.addPart(new Oil());
		partsOrder.addPart(new Fender());
		partsOrder.addPart(new Wheel());
		
		partsOrder.accept(new AtvPartsShippingVisitor());
		partsOrder.accept(new AtvPartsDisplayVisitor());
	}

}
