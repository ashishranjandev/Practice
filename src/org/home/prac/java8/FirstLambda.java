package org.home.prac.java8;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

	public static void main(String[] args) {
		// Anonymous class
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};
		// Lambda Expression
		FileFilter filterLambda = (pathname) -> pathname.getName().endsWith(".java");
		
		File dir = new File("X:/Codes/Java");
		File[] files = dir.listFiles(filterLambda);
		//File[] files = dir.listFiles(filter);
		for (File f : files) {
			System.out.println(f);
		}
	}
}
