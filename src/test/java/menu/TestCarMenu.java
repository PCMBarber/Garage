package menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.mockito.junit.MockitoJUnitRunner;

import automotives.Car;
import garage.Garage;
import utils.UserInput;

@RunWith(MockitoJUnitRunner.class)
public class TestCarMenu {
	
	@Mock
	private UserInput scan;
	
	@Mock
	private Garage garage;
	
	@InjectMocks
	private CarMenu carMenu;
	
	@Test
	public void testCreate() {
		when(scan.getString()).thenReturn("BMW", "Green");
		when(scan.getInt()).thenReturn(4, 5);
		Car expected = new Car("BMW", "Green", 4, 5);
		expected.setID(2);
		
		carMenu.create();
		
		verify(scan, times(2)).getString();
		verify(scan, times(2)).getInt();
		verify(garage, times(1)).addVehicle(expected);
	} 
}






