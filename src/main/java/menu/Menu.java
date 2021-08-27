package menu;

import utils.UserInput;

public class Menu {

	UserInput scan = UserInput.getInstance();
	CarMenu carMenu = new CarMenu();
	MotorbikeMenu motorbikeMenu = new MotorbikeMenu();

	public void start() {
		while (true) {
			System.out.println("What would you like to do?");
			System.out.println("1) Create");
			System.out.println("2) Read");
			System.out.println("3) Update");
			System.out.println("4) Delete");
			System.out.println("5) Exit");
			int input = scan.getInt();
			switch (input) {
			case 1:
				create();
				break;
			case 2:
				read();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.exit(0);
			default:
				start();
			}
		}
	}

	private void update() {
		System.out.println("Update what?");
		System.out.println("1) Car");
		System.out.println("2) Motorbike");
		int input = scan.getInt();
		switch (input) {
		case 1:
			carMenu.update();
			break;
		case 2:
			motorbikeMenu.update();
			break;
		default:
			System.out.println("Invalid");
		}
		
	}

	private void create() {
		System.out.println("Create what?");
		System.out.println("1) Car");
		System.out.println("2) Motorbike");
		int input = scan.getInt();
		switch (input) {
		case 1:
			carMenu.create();
			break;
		case 2:
			motorbikeMenu.create();
			break;
		default:
			System.out.println("Invalid");
		}
	}

	private void delete() {
		System.out.println("Delete what?");
		System.out.println("1) Car");
		System.out.println("2) Motorbike");
		int input = scan.getInt();
		switch (input) {
		case 1:
			carMenu.delete();
			break;
		case 2:
			motorbikeMenu.delete();
			break;
		default:
			System.out.println("Invalid");
		}

	}

	private void read() {
		System.out.println("Read what?");
		System.out.println("1) Car");
		System.out.println("2) Motorbike");
		int input = scan.getInt();
		switch (input) {
		case 1:
			carMenu.read();
			break;
		case 2:
			motorbikeMenu.read();
			break;
		default:
			System.out.println("Invalid");
		}
	}

}
