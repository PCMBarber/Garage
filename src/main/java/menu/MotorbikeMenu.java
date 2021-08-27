package menu;

import DAO.MotorbikeDAO;
import automotives.Motorbike;
import utils.UserInput;

public class MotorbikeMenu {
	
	private UserInput scan;
	private MotorbikeDAO motorbikeDAO;
	
	public MotorbikeMenu() {
		scan = UserInput.getInstance();
		motorbikeDAO = new MotorbikeDAO();
	}
	
	public MotorbikeMenu(UserInput scan, MotorbikeDAO motorbikeDAO) {
		this.scan = scan;
		this.motorbikeDAO = motorbikeDAO;
	}

	public void create() { 
		System.out.println("Manufacturer?");
		String maker = scan.getString();
		System.out.println("Colour?");
		String colour = scan.getString();
		System.out.println("CC?");
		int cubicCapacity = scan.getInt();
		System.out.println("No sidecars available");
		boolean sidecar = false;
		Motorbike userMotorbike = new Motorbike(maker, colour, cubicCapacity, sidecar);
		motorbikeDAO.create(userMotorbike);
	}

	public void delete() {
		int id=0;
		do {
			for(Motorbike motorbike: motorbikeDAO.readAll()) {
				System.out.println(motorbike);
			}
			System.out.println("Which ID to delete?");
			id = scan.getInt();
		} while(motorbikeDAO.readByID(id)==null);
		motorbikeDAO.delete(id);
		System.out.println("Successfully deleted");
	}

	public void read() {
		for(Motorbike motorbike: motorbikeDAO.readAll()) {
			System.out.println(motorbike);
		}
	}

	public void update() {
		int id=0;
		do {
			for(Motorbike motorbike: motorbikeDAO.readAll()) {
				System.out.println(motorbike);
			}
			System.out.println("Which ID to update?");
			id = scan.getInt();
		} while(motorbikeDAO.readByID(id)==null);
		
		System.out.println(motorbikeDAO.readByID(id));
		
		System.out.println("New manufacturer?");
		String maker = scan.getString();
		System.out.println("New colour?");
		String colour = scan.getString();
		System.out.println("New CC?");
		int cubicCapacity = scan.getInt();
		System.out.println("New number of doors?");
		boolean sidecar = false;
		Motorbike userMotorbike = new Motorbike(id, maker, colour, cubicCapacity, sidecar);
		motorbikeDAO.update(userMotorbike);
		System.out.println("Successfully updated");
	}
}
