package org.home.prac.design.bridge;

public class BridgeDemo {

	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("Rocky");
		movie.setRuntime("2:15");
		movie.setYear("1970");
		
		Formatter printFormatter = new PrintFormatter();
		Printer moviePrinter = new MoviePrinter(movie);
		
		String printerMaterial = moviePrinter.print(printFormatter);
		System.out.println(printerMaterial);
		
		Formatter htmlFormatter = new HtmlFormatter();
		String htmlMaterial = moviePrinter.print(htmlFormatter);
		System.out.println(htmlMaterial);
	}
}
