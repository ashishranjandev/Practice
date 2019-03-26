package org.home.prac.design.command;

//invoker
public class Switch {
	
	public void storeAndExecute(Command command) {
		command.execute();
	}
}
