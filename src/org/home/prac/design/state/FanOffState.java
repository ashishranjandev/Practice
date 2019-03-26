package org.home.prac.design.state;

public class FanOffState extends State {

	private Fan fan;
	
	public FanOffState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan to low state..");
		fan.setState(fan.getFanLowState());
	}

	@Override
	public String toString() {
		return "Fan is Off";
	}
}
