package org.home.prac.design.visitor;

public class AtvPartsDisplayVisitor implements AtvPartVisitor {

	@Override
	public void visit(Oil part) {
		System.out.println("We have oil");
		
	}

	@Override
	public void visit(Fender fender) {
		System.out.println("We have Fender");
	}

	@Override
	public void visit(Wheel wheel) {
		System.out.println("We have wheel");
	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("We have an order");
	}

}
