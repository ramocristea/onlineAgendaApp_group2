package org.example.copy.copy.main;

import org.example.copy.copy.Copy;
import org.example.copy.operations.Reader;
import org.example.copy.operations.impl.DatabaseReader;
import org.example.copy.operations.impl.DatabaseWriter;
import org.example.copy.operations.impl.FileWriter;
import org.example.copy.operations.impl.KeyboardReader;

public class OfficeCopy {
	
	public static void main(String[] args) {
		Reader keyboardReader = new KeyboardReader();
		Copy copy = new Copy(keyboardReader, new FileWriter());
		copy.read();
		copy.write();
		
		copy.setWriter(new DatabaseWriter());
		copy.setReader(new DatabaseReader());
		copy.write();
		copy.read();
		
		System.out.println();
		
		Copy dbCopy = new Copy(new DatabaseReader(), new DatabaseWriter());
		dbCopy.read();
		dbCopy.write();
	}

}
