package com.company.retailstore.util;

/**
 * Very simple logging class. In real project, we use a more powerful logging
 * library such as log4j, etc.
 */
public class Log {
	private String className;

	public Log(Object classInstance) {
		this.className = classInstance.getClass().getName();
	}

	public Log(String className) {
		this.className = className;
	}

	public void log(Object message) {
		System.out.println(className + ": " + message);
	}
}
