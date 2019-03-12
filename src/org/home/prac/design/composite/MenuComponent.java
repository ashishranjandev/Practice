package org.home.prac.design.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuComponent {

	String name;
	String url;
	List<MenuComponent> menuComponents = new ArrayList<>();
	
	public abstract String toString();
	
	String print(MenuComponent menuComponent) {
		StringBuilder builder = new StringBuilder(name);
		builder.append(":");
		builder.append(url);
		builder.append("\n");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuComponent> getMenuComponents() {
		return menuComponents;
	}

	public void setMenuComponents(List<MenuComponent> menuComponents) {
		this.menuComponents = menuComponents;
	}
	
}
