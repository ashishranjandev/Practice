package org.home.prac.design.bridge;

import java.util.List;

public class HtmlFormatter implements Formatter {

	@Override
	public String format(String header, List<KeyValue> details) {
		StringBuilder builder  = new StringBuilder();
		builder.append("<table>");
		builder.append("<th>");
		builder.append("Classification");
		builder.append("</th>");
		builder.append("<th>");
		builder.append(header);
		builder.append("</th>");
		
		for(KeyValue keyValue : details) {
			builder.append("<tr><td>");
			builder.append(keyValue.getKey());
			builder.append("</td><td>");
			builder.append(keyValue.getValue());
			builder.append("</td><tr>");
		}
		return null;
	}
	
}
