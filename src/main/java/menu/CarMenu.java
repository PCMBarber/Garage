package menu;

import DAO.CarDAO;
import automotives.Car;
import garage.Garage;
import utils.UserInput;

public class CarMenu {

	private UserInput scan;
	private CarDAO carDAO;
	
	public CarMenu() {
		scan = UserInput.getInstance();
		carDAO = new CarDAO();
	}
	
	public CarMenu(UserInput scan, CarDAO carDAO) {
		this.scan = scan;
		this.carDAO = carDAO;
	}

	public void create() { 
		System.out.println("Manufacturer?");
		String maker = scan.getString();
		System.out.println("Colour?");
		String colour = scan.getString();
		System.out.println("How many wheels?");
		int wheels = scan.getInt();
		System.out.println("How many doors?");
		int doors = scan.getInt();
		Car userCar = new Car(maker, colour, wheels, doors);
		carDAO.create(userCar);
	}

	public void delete() {
		int id=0;
		do {
			for(Car car: carDAO.readAll()) {
				System.out.println(car);
			}
			System.out.println("Which ID to delete?");
			id = scan.getInt();
		} while(carDAO.readByID(id)==null);
		carDAO.delete(id);
		System.out.println("Successfully deleted");
	}

	public void read() {
		for(Car car: carDAO.readAll()) {
			System.out.println(car);
		}
	}

	public void update() {
		int id=0;
		do {
			for(Car car: carDAO.readAll()) {
				System.out.println(car);
			}
			System.out.println("Which ID to update?");
			id = scan.getInt();
		} while(carDAO.readByID(id)==null);
		
		System.out.println(carDAO.readByID(id));
		
		System.out.println("New manufacturer?");
		String maker = scan.getString();
		System.out.println("New colour?");
		String colour = scan.getString();
		System.out.println("New number of wheels?");
		int wheels = scan.getInt();
		System.out.println("New number of doors?");
		int doors = scan.getInt();
		Car userCar = new Car(id, maker, colour, wheels, doors);
		carDAO.update(userCar);
		System.out.println("Successfully updated");
	}
}
