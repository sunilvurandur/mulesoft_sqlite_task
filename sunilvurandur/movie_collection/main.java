package com.sunilvurandur.movie_collection;
import java.sql.*;

public class main {
	public static void main(String args[]) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite3:sunilvurandur_fav_movies");
			System.out.println("database connected successfully");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
