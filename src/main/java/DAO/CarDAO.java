package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtils;

import automotives.Car;

public class CarDAO {
	
	public Car modelFromResultSet(ResultSet resultSet) throws SQLException {
		int ID = resultSet.getInt("ID");
		String maker = resultSet.getString("maker");
		String colour = resultSet.getString("colour");
		int wheels = resultSet.getInt("wheels");
		int doors = resultSet.getInt("doors");
		Car result = new Car(ID, maker, colour, wheels, doors);
		return result;
	}
	
	public void create(Car car) {
		try (Connection connection =DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into car values(?,?,?,?,?)");)
		{
			statement.setInt(1, car.getID());
			statement.setString(2, car.getMaker());
			statement.setString(3, car.getColour());
			statement.setInt(4, car.getWheels());
			statement.setInt(5, car.getDoors());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Car> readAll() {
		ArrayList<Car> found = new ArrayList<Car>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from car")) 
		{
			while(resultSet.next()) {
				found.add(modelFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public Car readByID(int id) {
		Car found = null;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from car where ID="+id)) 
		{
			if(resultSet.next()) {
				found = modelFromResultSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public void update(Car car) {
		try (Connection connection =DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("update car set maker=?,colour=?,wheels=?,doors=? where ID=?");)
		{
			statement.setString(1, car.getMaker());
			statement.setString(2, car.getColour());
			statement.setInt(3, car.getWheels());
			statement.setInt(4, car.getDoors());
			statement.setInt(5, car.getID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try (Connection connection =DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("delete from car where ID=?");)
		{
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
