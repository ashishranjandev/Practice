package org.home.prac.design.mediator;

//invoker
public class Switch {
	
	public void storeAndExecute(Command command) {
		command.execute();
	}
}
