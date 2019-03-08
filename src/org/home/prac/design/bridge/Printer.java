package org.home.prac.design.bridge;

import java.util.List;

public abstract class Printer {
	
	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}

	abstract protected List<KeyValue> getDetails();

	abstract protected String getHeader();
	
}
