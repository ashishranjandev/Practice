package org.home.prac.design.chain;

public class VicePresident extends Handler{

	@Override
	public void handleRequest(Request request) {
		if(RequestTypeEnum.PURCHASE.equals(request.getRequest())) {
			if(request.getOrderAmount() <= 1500) {
				System.out.println("Vice president can approve purchase below 1500.");
			} else {
				successor.handleRequest(request);
			}
		}
	}

}
