package org.home.prac.design.bridge;

import java.util.List;

public class PrintFormatter implements Formatter {

	@Override
	public String format(String header, List<KeyValue> details) {
		StringBuilder builder = new StringBuilder();
		builder.append(header);
		builder.append("\n");
		
		for(KeyValue keyValue : details) {
			builder.append(keyValue.getKey());
			builder.append(":");
			builder.append(keyValue.getValue());
			builder.append("\n");
		}
		return builder.toString();
	}

}
