package org.home.prac.design.bridge;

import java.util.ArrayList;
import java.util.List;

public class MoviePrinter extends Printer{
	
	private Movie movie;
	
	public MoviePrinter(Movie movie) {
		this.movie = movie;
	}

	@Override
	protected List<KeyValue> getDetails() {
		List<KeyValue> keyValues = new ArrayList<>();
		keyValues.add(new KeyValue("Title", movie.getTitle()));
		keyValues.add(new KeyValue("Year", movie.getYear()));
		keyValues.add(new KeyValue("Runtime", movie.getRuntime()));
		keyValues.add(new KeyValue("Classification", movie.getClassification()));
		
		return keyValues;
	}

	@Override
	protected String getHeader() {
		return movie.getClassification();
	}
	
}
