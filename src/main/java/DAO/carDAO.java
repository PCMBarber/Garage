package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.DBUtils;

import automotives.Car;

public class carDAO {
	
	public Car modelFromResultSet(ResultSet resultSet) throws SQLException {
		int ID = resultSet.getInt("ID");
		String maker = resultSet.getString("maker");
		String colour = resultSet.getString("colour");
		int wheels = resultSet.getInt("wheels");
		int doors = resultSet.getInt("doors");
		Car result = new Car(maker, colour, wheels, doors);
		result.setID(ID);
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
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery
	}

	public void update() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery
	}

	public void delete() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery
	}
}
