package org.home.prac.design.state;

public class FanHighState extends State {

	private Fan fan;
	
	public FanHighState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan to off state..");
		fan.setState(fan.getFanOffState());
	}
	
	@Override
	public String toString() {
		return "Fan is high";
	}

}
