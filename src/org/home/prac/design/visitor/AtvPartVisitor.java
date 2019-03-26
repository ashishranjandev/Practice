package org.home.prac.design.visitor;

public interface AtvPartVisitor {

	void visit(Oil part);

	void visit(Fender fender);

	void visit(Wheel wheel);

	void visit(PartsOrder partsOrder);

}
