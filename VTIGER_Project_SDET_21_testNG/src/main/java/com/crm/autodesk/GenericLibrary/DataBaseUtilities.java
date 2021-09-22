package com.crm.autodesk.GenericLibrary;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;


public class DataBaseUtilities 
{
		Connection conn;
		Driver dRef;
		public void connectToDB() throws Throwable {
			
			DriverManager.registerDriver(dRef);
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
		}
		
		public void closeDB() throws SQLException {
			conn.close();
		}
		
		public String getDataFromDB(String query, int columnIndex) throws SQLException {
			ResultSet res = conn.createStatement().executeQuery(query);
			String value= null;
			while(res.next()) {
				 value = res.getString(columnIndex);
			}
			return value;
		}
		
	}


