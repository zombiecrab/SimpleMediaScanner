package com.mediascanner.database;

import java.sql.*;

public class Database {
	Connection c = null;
	Statement stmt = null;

	public Database() {

		dbConnect();

		
	}
	private void dbConnect(){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:mediascanner.db");
			stmt = c.createStatement();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public String isExtensionValid(String extenstion) {
		
		ResultSet rs = null;
		String type = null;
		try {
			rs = stmt.executeQuery("SELECT ext, media_type FROM media_extensions WHERE ext = \""+extenstion+"\";");

			if (rs.next()){
				type = rs.getString("media_type");
				System.out.println(type);
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return type;
	}
}
