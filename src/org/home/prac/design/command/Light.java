package org.home.prac.design.command;
//receiver
public class Light {
	
	private boolean isOn = false;

	public boolean isOn() {
		return isOn;
	}
	
	public void turnOn() {
		isOn = true;
		System.out.println("Light has been turned on");
	}

	public void toggle() {
		if(isOn) {
			isOn = false;
			System.out.println("Light has been turned off");
		} else {
			isOn = true;
			System.out.println("Light has been turned on");
		}
	}
}
