package org.home.prac.design.state;

public class FanWithoutState {

	final static int OFF = 0;
	final static int LOW = 1;
	final static int MED = 2;
	
	int state = OFF;
	
	public void pullChain() {
		if(state == OFF) {
			System.out.println("Turning fan to low");
			state = LOW;
		} else if (state == LOW) {
			System.out.println("Turning fan to medium");
			state = MED;
		} else if (state == MED) {
			System.out.println("Turning fan to off");
			state = OFF;
		}
	}

	@Override
	public String toString() {
		if (state == OFF) {
			System.out.println("Fan is off");
		} else if (state == LOW) {
			System.out.println("Fan is low");
		} else if (state == MED) {
			System.out.println("Fan is medium");
		}
		return "Invalid State";
	}
}
