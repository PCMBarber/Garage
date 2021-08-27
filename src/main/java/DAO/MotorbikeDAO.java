package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import automotives.Motorbike;
import utils.DBUtils;

public class MotorbikeDAO {
	
	public Motorbike modelFromResultSet(ResultSet resultSet) throws SQLException {
		int ID = resultSet.getInt("ID");
		String maker = resultSet.getString("maker");
		String colour = resultSet.getString("colour");
		int cubicCapacity = resultSet.getInt("cubicCapacity");
		boolean sidecar = resultSet.getBoolean("sidecar");
		Motorbike result = new Motorbike(ID, maker, colour, cubicCapacity, sidecar);
		return result;
	}
	
	public void create(Motorbike motorbike) {
		try (Connection connection =DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("insert into motorbike values(?,?,?,?,?)");)
		{
			statement.setInt(1, motorbike.getID());
			statement.setString(2, motorbike.getMaker());
			statement.setString(3, motorbike.getColour());
			statement.setInt(4, motorbike.getCubicCapacity());
			statement.setBoolean(5, motorbike.isSidecar());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Motorbike> readAll() {
		ArrayList<Motorbike> found = new ArrayList<Motorbike>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from motorbike")) 
		{
			while(resultSet.next()) {
				found.add(modelFromResultSet(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public Motorbike readByID(int id) {
		Motorbike found = null;
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from motorbike where ID="+id)) 
		{
			if(resultSet.next()) {
				found = modelFromResultSet(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}

	public void update(Motorbike motorbike) {
		try (Connection connection =DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("update motorbike set maker=?,colour=?,cubicCapacity=?,sidecar=? where ID=?");)
		{
			statement.setString(1, motorbike.getMaker());
			statement.setString(2, motorbike.getColour());
			statement.setInt(3, motorbike.getCubicCapacity());
			statement.setBoolean(4, motorbike.isSidecar());
			statement.setInt(5, motorbike.getID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try (Connection connection =DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("delete from motorbike where ID=?");)
		{
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
