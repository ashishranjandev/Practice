package org.home.prac.design.mediator;

public class TurnAllLightsCommand implements Command {

	private Mediator mediator;
	
	public TurnAllLightsCommand(Mediator mediator) {
		this.mediator = mediator;
	}
	
	@Override
	public void execute() {
		mediator.turnOnAllLights();
	}

}
