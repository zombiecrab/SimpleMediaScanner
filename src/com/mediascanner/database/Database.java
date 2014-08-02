package com.mediascanner.database;

import java.sql.*;

public class Database {
	Connection c = null;

	public Database() {

		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:mediascanner.db");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public String isExtensionValid(String extenstion) {
		Statement stmt = null;
		String type = null;
		try {
			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT ext, media_type FROM media_extensions WHERE ext = \""+extenstion+"\";");
			
			type = rs.getString("media_type");
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return type;
	}
}
