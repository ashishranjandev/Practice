package org.home.prac.design.observer;

public class ObserverDemo {
	
	public static void main(String[] args) {
		Subject subject = new MessageStream();
		
		IPhoneClient iphone = new IPhoneClient(subject);
		AndroidClient android = new AndroidClient(subject);
		
		iphone.addMessage("Here is 1st Message");
		android.addMessage("Here is 2nd Message");
	}
}

