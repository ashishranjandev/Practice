package org.home.prac.design.decorator;

public class MeatDecorator extends SandwichDecorator {

	public MeatDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}
	
	public String make() {
		return customSandwich.make()+addMeat();
	}
	
	private String addMeat(){
		return " + Turkey";
	}
}
