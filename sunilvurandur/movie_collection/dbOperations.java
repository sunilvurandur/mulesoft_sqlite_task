package com.sunilvurandur.movie_collection;

import java.sql.*;

public class dbOperations {
		String query = "";

		public void createDB(String dbName) {

			String url = "jdbc:sqlite:" + dbName + ".db";
			try {
				Connection conn = DriverManager.getConnection(url);

	            if (conn != null) 
				{  
	                System.out.println("Creating Database");
	            }
	            conn.close();
	        }

	        catch (SQLException e) {  
	        	System.out.println(e.getMessage());
	        }

		}
		public void createTable(String dbName,String tableName) {
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:mulesoftTraining.db");
				Statement statement = con.createStatement();
		        statement.setQueryTimeout(15);
		        
		        String query = "CREATE TABLE IF NOT EXISTS sunilvurandur_fav_movies(id integer PRIMARY KEY AUTOINCREMENT,movie_name text NOT NULL,hero_name text NOT NULL, actress_name text NOT NULL, director_name text NOT NULL, year text NOT NULL, UNIQUE(hero_name, movie_name));";
		        statement.execute(query);
		        System.out.println("Table Creation.");
			}

			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		public void insertingData(String movie_name,String hero_name, String actress_name, String director_name, int year) {

			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:sunilvurandur_fav_movies.db");
				Statement statement = con.createStatement();
		        statement.setQueryTimeout(30);
		        String query = "INSERT INTO movies(movie_name, hero_name, actress_name, director_name, year) VALUES(?,?,?,?,?)";
		        
		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setString(1, movie_name);
		        pstmt.setString(2, hero_name);     
		        pstmt.setString(3, actress_name);
		        pstmt.setString(4, director_name);  
		        pstmt.setInt(5, year);
			}

			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
		
		public void retrievingData(String searchType, String searchByName) {

			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:sunilvurandur_fav_movies.db");
				Statement statement = con.createStatement();
		        statement.setQueryTimeout(10);
		        switch(searchType) {
		        case "byHero":{
		        	query = "SELECT * FROM sunilvurandur_fav_movie WHERE hero_name = " + searchByName + ";";
		        	break;
		        }
		        case "byActress":{
		        	query = "SELECT * FROM sunilvurandur_fav_movie WHERE actress_name = " + searchByName + ";";
		        	break;
		        }
		        case "byDirector":{
		        	query = "SELECT * FROM sunilvurandur_fav_movie WHERE director_name = " + searchByName + ";";
		        	break;
		        }
		        case "bymovieName":{
		        	query = "SELECT * FROM sunilvurandur_fav_movie WHERE movie_name = " + searchByName + ";";
		        	break;
		        }
		        case "byYear":{
		        	query = "SELECT * FROM sunilvurandur_fav_movie WHERE year = " + searchByName + ";";
		        	break;
		        }
		        default : {
		        	System.out.println("un supported selection");
		        	break;
		        }
		        }
		        if(query !="") {
					ResultSet rs = statement.executeQuery(query);
			        String format = "%-10s-\t%s-10s-\t%s-10s-\t%s";

			        System.out.printf(format, "Movie Name", "Hero Name", "Actress Name","Director Name", "Release Date");
			        

			        while (rs.next()) {
			        	System.out.printf(format,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		            }
		        }
			
			}

			catch(Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
}
