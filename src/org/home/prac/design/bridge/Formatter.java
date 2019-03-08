package org.home.prac.design.bridge;

import java.util.List;

public interface Formatter {

	String format(String header, List<KeyValue> details);
}
