package org.home.prac.design.observer;

public class IPhoneClient extends Observer {

	public IPhoneClient(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	public void addMessage(String message) {
		subject.setState(message+" - sent from the iPhone");
	}

	@Override
	void update() {
		System.out.println("Phone Stream : "+subject.getState());
	}

}
