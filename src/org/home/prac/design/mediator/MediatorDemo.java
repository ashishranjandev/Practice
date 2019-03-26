package org.home.prac.design.mediator;

public class MediatorDemo {

	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		
		Light bedroomLight = new Light("bedroom");
		Light kitchenLight = new Light("kitchen");
		
		mediator.registerLights(bedroomLight);
		mediator.registerLights(kitchenLight);
		
		Command turnOnAllLightsCommand = new TurnAllLightsCommand(mediator);
		turnOnAllLightsCommand.execute();
	}
}
