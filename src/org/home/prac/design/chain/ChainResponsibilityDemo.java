package org.home.prac.design.chain;

public class ChainResponsibilityDemo {

	public static void main(String[] args) {
		CEO sam = new CEO();
		VicePresident tom = new VicePresident();
		Director ashish = new Director();
		
		ashish.setSuccessor(tom);
		tom.setSuccessor(sam);
		
		Request request1 = new Request(RequestTypeEnum.CONFERENCE, 500);
		ashish.handleRequest(request1);
		
		Request request2 = new Request(RequestTypeEnum.PURCHASE, 1200);
		ashish.handleRequest(request2);
		
		Request request3 = new Request(RequestTypeEnum.PURCHASE, 5000);
		ashish.handleRequest(request3);
	}
}
