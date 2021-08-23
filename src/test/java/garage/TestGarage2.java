package garage;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import automotives.Car;
import automotives.Vehicle;

public class TestGarage2 {
	Garage garage = Garage.getInstance();
	
	@BeforeClass
	public static void init() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void stop() {
		System.out.println("After Class");
	}
	
	@After
	public void tearDown() {
		System.out.println("After Test");
	}
	
	@Before
	public void setUp() {
		System.out.println("Before Test");
		garage.empty();
	}
	
	@Test
	public void testAddVehicle() {
		System.out.println("testAddVehicle");
		ArrayList<Vehicle> testArray = new ArrayList<Vehicle>();
		assertEquals(testArray, garage.getGarage());
		
		Car testCar = new Car("BMW", "Blue", 4, 5);
		garage.addVehicle(testCar);
		
		testArray.add(testCar);
		assertEquals(testArray, garage.getGarage());
	}
	
	@Test
	public void testGetGarage() {
		System.out.println("testGetGarage");
		assertEquals(new ArrayList<Vehicle>(), garage.getGarage());
	}
}
