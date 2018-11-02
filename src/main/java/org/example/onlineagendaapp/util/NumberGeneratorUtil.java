package org.example.onlineagendaapp.util;

import java.util.Random;

public class NumberGeneratorUtil {
	
	public static int getNextRandomId() {
		Random random = new Random();
		return random.nextInt(100);
	}

}
