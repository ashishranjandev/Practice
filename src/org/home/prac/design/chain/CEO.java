package org.home.prac.design.chain;

public class CEO extends Handler {

	@Override
	public void handleRequest(Request request) {
		System.out.println("CEO can approve everything");
	}

}
