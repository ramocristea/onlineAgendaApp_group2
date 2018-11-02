package org.example.copy.copy;

import org.example.copy.operations.Reader;
import org.example.copy.operations.Writer;

public class Copy implements Reader, Writer {

	private Reader reader;
	private Writer writer;

	public Copy() {
	}

	public Copy(Reader reader, Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public Object read() {
		reader.read();
		
		return null;
	}

	public Object write() {
		writer.write();
		
		return null;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public Writer getWriter() {
		return writer;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	
}
