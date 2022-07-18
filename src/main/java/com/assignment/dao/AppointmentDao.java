package com.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.assignment.model.Appointment;

public class AppointmentDao {
	
	private static final String INSERT_APMS_SQL = "INSERT INTO appointment" + "  (patientName, patientEmail, patientAge, reason, slot, doctorName, location, doctorid) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_APMS_BY_ID = "select * from appointment where id =?";
	private static final String SELECT_ALL_APMS = "select * from appointment";
	private static final String SELECT_DOCTOR_APPOINTMENT = "select * from appointment where doctorid=?";
	
	
	DBConnection con = new DBConnection();
	
	public int fetchdocId(String docname) {
		
		int id = 0;
		System.out.println("doc name" + docname);

		String q = "SELECT * FROM doctor where name='"+docname+"'";
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Appointment> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(q)) {
			System.out.println(preparedStatement);
			//preparedStatement.setInt(5, id1);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				id = rs.getInt("id");
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id;
	
	}
	
	public void insertAppointment(Appointment app) throws SQLException {
		System.out.println(INSERT_APMS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = con.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APMS_SQL)) {
			preparedStatement.setString(1, app.getPatientName());
			preparedStatement.setString(2, app.getPatientEmail());
			preparedStatement.setString(3, app.getPatientAge());
			preparedStatement.setString(4, app.getReason());
			preparedStatement.setString(5, app.getSlot());
			preparedStatement.setString(6, app.getDoctorName());
			preparedStatement.setString(7, app.getLocation());
			System.out.println("**********************************");
			preparedStatement.setInt(8, app.getDoctorid());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<String> getSlots(){
		List<String> list = new ArrayList<>();
		list.add("09:20 AM");
		list.add("09:40 AM");
		list.add("10:00 AM");
		list.add("10:20 AM");
		list.add("10:40 AM");
		list.add("11:00 AM");
		list.add("11:20 AM");
		list.add("11:40 AM");
		list.add("12:00 PM");
		list.add("12:20 PM");
		list.add("12:40 PM");
		list.add("01:00 PM");
		list.add("01:20 PM");
		list.add("01:40 PM");
		list.add("02:00 PM");
		list.add("02:20 PM");
		list.add("02:40 PM");
		list.add("03:00 PM");
		list.add("03:20 PM");
		list.add("03:40 PM");
		list.add("04:00 PM");
		list.add("04:20 PM");
		list.add("04:40 PM");
		list.add("05:00 PM");
		list.add("05:20 PM");
		list.add("05:40 PM");
		list.add("06:00 PM");
		list.add("06:20 PM");
		
		return list;
	}
	public List<Appointment> DoctorAppointments(int id1) {
		System.out.println("iddddddddddddddd" + id1);
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Appointment> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement("select * from appointment where doctorid="+id1);) {
			System.out.println(preparedStatement);
			//preparedStatement.setInt(5, id1);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String patientName = rs.getString("patientName");
				String patientEmail = rs.getString("patientEmail");
				String patientAge = rs.getString("patientAge");
				String reason = rs.getString("reason");
				String slot = rs.getString("slot");
				String doctorName = rs.getString("doctorName");
				String location = rs.getString("location");
				users.add(new Appointment(id, patientName, patientEmail, patientAge, reason, slot, doctorName, location));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public List<Appointment> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Appointment> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = con.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APMS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String patientName = rs.getString("patientName");
				String patientEmail = rs.getString("patientEmail");
				String patientAge = rs.getString("patientAge");
				String reason = rs.getString("reason");
				String slot = rs.getString("slot");
				String doctorName = rs.getString("doctorName");
				String location = rs.getString("location");
				int docid = rs.getInt("doctorid");
				users.add(new Appointment(id, patientName, patientEmail, patientAge, reason, slot, doctorName, location, docid));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
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
