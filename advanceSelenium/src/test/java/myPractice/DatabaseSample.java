package myPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class DatabaseSample {
	@Test
	public  void database() throws Throwable {
		Driver ref=new Driver();
		DriverManager.registerDriver(ref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery("select * from project");
		
		while(result.next()) {
			System.out.println(result.getString(1));
			break;
		}
		conn.close();
		
	}

}
