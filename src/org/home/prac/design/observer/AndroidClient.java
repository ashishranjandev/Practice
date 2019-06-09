package org.home.prac.design.observer;

public class AndroidClient extends Observer {

	public AndroidClient(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	public void addMessage(String message) {
		subject.setState(message+" - sent from the Android Phone");
	}

	@Override
	void update() {
		System.out.println("Android Phone Stream : "+subject.getState());
	}

}
