package org.example.copy.operations.impl;

import org.example.copy.operations.Writer;

public class FileWriter implements Writer {

	@Override
	public Object write() {
		System.out.println("Write to file");
		
		return null;
	}

}
