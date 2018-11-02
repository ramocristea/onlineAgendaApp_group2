package org.example.copy.copy;

import org.example.copy.operations.impl.DatabaseReader;
import org.example.copy.operations.impl.DatabaseWriter;
import org.example.copy.operations.impl.FileWriter;
import org.example.copy.operations.impl.KeyboardReader;

public class CopyBeforeRefactoring {
	
	private KeyboardReader keyboardReader;
	private FileWriter fileWriter;
	private DatabaseWriter databaseWriter;
	private DatabaseReader databaseReader;
	
	public CopyBeforeRefactoring(KeyboardReader keyboardReader, FileWriter fileWriter, DatabaseWriter databaseWriter, DatabaseReader databaseReader) {
		this.keyboardReader = keyboardReader;
		this.fileWriter = fileWriter;
		this.databaseWriter = databaseWriter;
		this.databaseReader = databaseReader;
	}
	
	public void readFromKeyboard() {
		keyboardReader.read();
	}

	public void writeToFile() {
		fileWriter.write();
	}
	
	public void writeToDb() {
		databaseWriter.write();
	}
	
	public void readFromDB() {
		databaseReader.read();
	}
	
	public KeyboardReader getKeyboardReader() {
		return keyboardReader;
	}

	public void setKeyboardReader(KeyboardReader keyboardReader) {
		this.keyboardReader = keyboardReader;
	}

	public FileWriter getFileWriter() {
		return fileWriter;
	}

	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	public DatabaseWriter getDatabaseWriter() {
		return databaseWriter;
	}

	public void setDatabaseWriter(DatabaseWriter databaseWriter) {
		this.databaseWriter = databaseWriter;
	}

}
