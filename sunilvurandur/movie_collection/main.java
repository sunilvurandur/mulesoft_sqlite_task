package com.sunilvurandur.movie_collection;
import java.sql.*;


public class main {
	public static void main(String args[]) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite3:sunilvurandur_fav_movies.db");
			System.out.println("database connected successfully");
			dbOperations dbo  = new dbOperations();
			
			dbo.createDB("sunilvurandur");
			
			dbo.createTable("sunilvurandur","sunilvurandur_fav_movies");
			
			// Data Insertion Section
			
			dbo.insertingData("maari","dhanush","kajal", "balaji mohan", 2015);   
            dbo.insertingData("bahubali", "prabhas", "anushka", "rajamouli", 2015);
            dbo.insertingData("pushpa", "allu arjun", "reshmika mandana", "sukumar", 2022);
            dbo.insertingData("darbar", "rajini kanth", "nainatara", "murugadoss", 2020);
            dbo.insertingData("bahubali2", "prabhas", "anushka", "rajamouli", 2018);
            dbo.insertingData("saaho", "prabhas", "shraddha kapoor", "sujith", 2020);
            System.out.println("Data Inserted Into The Table.");
            
            
            

            System.out.println("Querying Details....:");   // Data Querying Section
            dbo.retrievingData(null,null);
            System.out.println("Querying Details with a Actor Name:");
            dbo.retrievingData("byHero","rajinikanth");
            con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
