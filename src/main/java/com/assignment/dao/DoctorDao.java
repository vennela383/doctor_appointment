package com.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.model.Doctor;

public class DoctorDao {
	
	private static final String INSERT_Doctor_SQL = "INSERT INTO doctor" + "  (name, email, category, experience, location , fee) VALUES " + " (?, ?, ?, ?, ?, ?);";

	private static final String SELECT_Doctor_BY_ID = "select * from doctor where id =?";
	private static final String SELECT_ALL_Doctors = "select * from doctor";
	private static final String FetchDoctorNames = "select * from doctor";

	//private static final String DELETE_Doctor_SQL = "delete from doctor where id = ?;";
	//private static final String UPDATE_Doctor_SQL = "update users set name = ?,email= ?, speciality =? where id = ?;";
	DBConnection con = new DBConnection();
	
	public List<Doctor> fetchCategory(){

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Doctor> doctor = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Doctors);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String category = rs.getString("category");
				String experience = rs.getString("experience");
				String location = rs.getString("location");
				int fee = Integer.parseInt(rs.getString("fee"));
				doctor.add(new Doctor(id, name, email, category, experience, location, fee));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return doctor;
	}
	
	//insert doctor details into DB
	public void insertDoctor(Doctor doc) throws SQLException {
		System.out.println(INSERT_Doctor_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Doctor_SQL)) {
			preparedStatement.setString(1, doc.getName());
			preparedStatement.setString(2, doc.getEmail());
			preparedStatement.setString(3, doc.getCategory());
			preparedStatement.setString(4, doc.getExperience());
			preparedStatement.setString(5, doc.getLocation());
			preparedStatement.setInt(6, doc.getFee());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<String> getGender(){
		List<String> gender = new ArrayList<>();
		gender.add("male");
		gender.add("female");
		return gender;
	}
	
	public List<Doctor> selectAllDoctors() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Doctor> doctor = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Doctors);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String category = rs.getString("category");
				String experience = rs.getString("experience");
				String location = rs.getString("location");
				int fee = Integer.parseInt(rs.getString("fee"));
				doctor.add(new Doctor(id, name, email, category, experience, location, fee));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return doctor;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
