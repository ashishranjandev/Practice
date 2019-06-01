package org.home.prac.design.singleton;

public class Singleton {

	private static Singleton obj = null;

	private Singleton() {}; // private constructor

	public static Singleton getInstance() {
		if (null == obj) {
			synchronized (Singleton.class) {
				if (null == obj) {
					obj = new Singleton();
				}
			}
		}
		return obj;
	}
}
