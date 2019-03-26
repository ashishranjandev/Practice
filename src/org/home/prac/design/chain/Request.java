package org.home.prac.design.chain;

public class Request {

	RequestTypeEnum request;

	int orderAmount;
	
	public Request(RequestTypeEnum request, int orderAmount) {
		super();
		this.request = request;
		this.orderAmount = orderAmount;
	}

	public RequestTypeEnum getRequest() {
		return request;
	}

	public void setRequest(RequestTypeEnum request) {
		this.request = request;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	
}
