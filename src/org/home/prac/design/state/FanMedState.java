package org.home.prac.design.state;

public class FanMedState extends State {

	private Fan fan;

	public FanMedState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan to high state..");
		fan.setState(fan.getFanHighState());
	}
	
	@Override
	public String toString() {
		return "Fan is Medium";
	}

}
