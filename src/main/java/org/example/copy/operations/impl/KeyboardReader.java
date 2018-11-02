package org.example.copy.operations.impl;

import org.example.copy.operations.Reader;

public class KeyboardReader implements Reader {

	@Override
	public Object read() {
		System.out.println("Read from keyboard");
		
		return null;
	}

}
