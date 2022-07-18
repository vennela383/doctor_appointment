package com.assignment.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.assignment.dao.AppointmentDao;
import com.assignment.dao.DoctorDao;
import com.assignment.model.Appointment;
import com.assignment.model.Doctor;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private DoctorDao doctorDao;
	private AppointmentDao appDao;
	
	public void init() {
		doctorDao = new DoctorDao();
		appDao = new AppointmentDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action1 = request.getServletPath();
		String action = request.getRequestURI();
		action = action.substring(action.lastIndexOf("/")).toLowerCase();
		System.out.println("action val :::"+ action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertDoctor(request, response);
				break;
			case "/new1":
				showNewAppointmentForm(request, response);
				break;
			case "/insert1":
				insertAppointment(request, response);
				break;
			case "/list2":
				listAppointmentForm(request, response);
				break;
			case "/docappointments":
				listDoctorAppointments(request, response);
				break;
			default:
				listDoctors(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void insertDoctor(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String category = request.getParameter("category");
		String experience = request.getParameter("experience");
		String location = request.getParameter("location");
		int fee = Integer.parseInt(request.getParameter("fee"));
		Doctor newUser = new Doctor(name, email, category, experience, location, fee);
		doctorDao.insertDoctor(newUser);
		response.sendRedirect("list");
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("show new form");
		List<Doctor> listGender = doctorDao.selectAllDoctors();
		request.setAttribute("listGender", listGender);
		RequestDispatcher dispatcher = request.getRequestDispatcher("doctorForm.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listDoctors(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("calling doctor Service");
		List<Doctor> listUser = doctorDao.selectAllDoctors();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("doctorList.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void listAppointmentForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Appointment> listUser = appDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("appList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listDoctorAppointments(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("query String :" + request.getQueryString());
		String[] words=request.getQueryString().split("=");
		System.out.println(words[1]);
		int id = Integer.parseInt(words[1]);
		List<Appointment> listUser = appDao.DoctorAppointments(id);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DAList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewAppointmentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Doctor> listNames = doctorDao.selectAllDoctors();
        request.setAttribute("listNames", listNames);
        
        List<String> slots = appDao.getSlots();
        request.setAttribute("slots", slots);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("appForm.jsp");
		dispatcher.forward(request, response);
	}

	private void insertAppointment(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String patientName = request.getParameter("patientName");
		String patientEmail = request.getParameter("patientEmail");
		String patientAge = request.getParameter("patientAge");
		String reason = request.getParameter("reason");
		String slot = request.getParameter("slot");
		String doctorName = request.getParameter("doctorName");
		String location = request.getParameter("location");
		int docId = appDao.fetchdocId(doctorName);
		System.out.println("docId :"+docId);
		//int docId = Integer.parseInt(request.getParameter("doctorid"));
				
		Appointment newUser = new Appointment(patientName, patientEmail, patientAge, reason, slot, doctorName, location, docId);
		appDao.insertAppointment(newUser);
		response.sendRedirect("list2");
	}

}
