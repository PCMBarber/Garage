package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.Properties;

public class DBUtils {

	private final String dbUrl;

	private final String dbUser;

	private final String dbPassword;

	private DBUtils(String properties) {
		Properties dbProps = new Properties();
		try (InputStream fis = ClassLoader.getSystemResourceAsStream(properties)) {
			dbProps.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.dbUrl = dbProps.getProperty("db.url", "");
		this.dbUser = dbProps.getProperty("db.user", "");
		this.dbPassword = dbProps.getProperty("db.password", "");
	}

	public DBUtils() {
		this("db.properties");
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}

	private static DBUtils instance;

	public static DBUtils connect() {
		instance = new DBUtils();
		return instance;
	}

	public static DBUtils connect(String properties) {
		instance = new DBUtils(properties);
		return instance;
	}

	public static DBUtils getInstance() {
		if (instance == null) {
			instance = new DBUtils();
		}
		return instance;
	}
}
