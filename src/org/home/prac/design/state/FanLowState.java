package org.home.prac.design.state;

public class FanLowState extends State {

	private Fan fan;
	
	public FanLowState(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void handleRequest() {
		System.out.println("Turning fan to med state..");
		fan.setState(fan.getFanMedState());
	}
	
	@Override
	public String toString() {
		return "Fan is Low";
	}

}
