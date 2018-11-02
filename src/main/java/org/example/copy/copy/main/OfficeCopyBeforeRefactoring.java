package org.example.copy.copy.main;

import org.example.copy.copy.CopyBeforeRefactoring;
import org.example.copy.operations.impl.DatabaseReader;
import org.example.copy.operations.impl.DatabaseWriter;
import org.example.copy.operations.impl.FileWriter;
import org.example.copy.operations.impl.KeyboardReader;

public class OfficeCopyBeforeRefactoring {
	
	public static void main(String[] args) {
		CopyBeforeRefactoring copy = new CopyBeforeRefactoring(new KeyboardReader(), new FileWriter(), new DatabaseWriter(), new DatabaseReader());
		
		copy.readFromKeyboard();
		copy.writeToFile();
		copy.writeToDb();
		copy.readFromDB();
	}

}
