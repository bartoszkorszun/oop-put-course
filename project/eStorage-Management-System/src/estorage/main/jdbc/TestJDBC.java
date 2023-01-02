package estorage.main.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/oop-put-courier-warehouse?useSSL=false";
		String user = "warehousedb";
		String pass = "warehousedb";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successfull");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
