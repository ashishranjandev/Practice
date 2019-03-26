package org.home.prac.design.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartsOrder implements AtvPart {
	
	private List<AtvPart> parts = new ArrayList<>();
	
	public void addPart(AtvPart part) {
		parts.add(part);
	}
	
	public List<AtvPart> getParts() {
		return Collections.unmodifiableList(parts);
	}
	
	@Override
	public void accept(AtvPartVisitor visitor) {
		for(AtvPart part : parts) {
			part.accept(visitor);
		}
		visitor.visit(this);
	}
}
