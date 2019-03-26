package org.home.prac.design.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

	private List<Light> lights = new ArrayList<>();
	
	public void registerLights(Light light) {
		lights.add(light);
	}
	
	public void turnOnAllLights() {
		for(Light light: lights) {
			if(!light.isOn()) {
				light.turnOn();
			}
		}
	}
}
