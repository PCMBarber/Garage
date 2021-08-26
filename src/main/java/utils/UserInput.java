package utils;

import java.util.Scanner;

public class UserInput {
	
	private Scanner scan = new Scanner(System.in);
	
	private static UserInput instance = null;
	
	private UserInput() {
		
	}
	
	public static UserInput getInstance() {
		if(instance == null) {
			instance = new UserInput();
		}
		return instance;
	}
	
	public String getString() {
		return scan.nextLine();
	}
	
	public int getInt() {
		while(true) {
			try {
				int input = Integer.parseInt(getString());
				return input;
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
	}
	
}
