package org.home.prac.design.chain;

public class Director extends Handler {

	@Override
	public void handleRequest(Request request) {
		if(RequestTypeEnum.CONFERENCE.equals(request.getRequest())) {
			System.out.println("Director can approve conferences");
		} else {
			successor.handleRequest(request);
		}
	}

}
