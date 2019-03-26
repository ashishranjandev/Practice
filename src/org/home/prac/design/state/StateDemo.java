package org.home.prac.design.state;

public class StateDemo {

	public static void main(String[] args) {
		//FanWithoutState fan = new FanWithoutState();
		Fan fan = new Fan();
		System.out.println(fan);
		
		fan.pullChain();
		System.out.println(fan);
		
		fan.pullChain();
		System.out.println(fan);
		
		fan.pullChain();
		System.out.println(fan);
		
		fan.pullChain();
		System.out.println(fan);
	}
}
