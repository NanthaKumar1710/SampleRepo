package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseutility {
	Connection con;

	public void getDbConnection() {
		try {
			Driver driver = new Driver();

			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql:localhost:3333/projects", "root@%", "root");

		} catch (Exception e) {
		}

	}

	public void closeDbConnection() {
		try {
			con.close();

		} catch (Exception e) {
		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet result = null;
		try {
			Statement stat = con.createStatement();
			stat.executeQuery(query);

		} catch (Exception e) {
		}

		return result;

	}

	public int executeNonSelect(String query) {
		int result = 0;
		try {
			Statement stat = con.createStatement();
			stat.executeUpdate(query);

		} catch (Exception e) {
		}
		return result;

	}

}
