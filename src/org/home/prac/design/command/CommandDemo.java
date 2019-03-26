package org.home.prac.design.command;

import java.util.Arrays;

public class CommandDemo {

	public static void main(String[] args) {
		Light bedroomLight = new Light();
		Light kitchenLight = new Light();
		Switch lightSwitch = new Switch();
		
		Command toggleCommand = new ToggleCommand(bedroomLight);
		lightSwitch.storeAndExecute(toggleCommand);
		
		AllLightsCommand allLightCommand = new AllLightsCommand(Arrays.asList(kitchenLight, bedroomLight));
		lightSwitch.storeAndExecute(allLightCommand);
	}

}
