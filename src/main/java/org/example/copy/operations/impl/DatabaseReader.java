package org.example.copy.operations.impl;

import org.example.copy.operations.Reader;

public class DatabaseReader implements Reader {

	@Override
	public Object read() {
		System.out.println("Read from database");
		
		return null;
	}

}
