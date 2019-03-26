package org.home.prac.design.mediator;
//receiver
public class Light {
	
	private boolean isOn = false;

	private String location = "";
	
	public Light() {}
	
	public Light(String location) {
		this.location = location;
	}
	public boolean isOn() {
		return isOn;
	}
	
	public void turnOn() {
		isOn = true;
		System.out.println(location+" Light has been turned on");
	}

	public void toggle() {
		if(isOn) {
			isOn = false;
			System.out.println(location+" Light has been turned off");
		} else {
			isOn = true;
			System.out.println(location+" Light has been turned on");
		}
	}
}
