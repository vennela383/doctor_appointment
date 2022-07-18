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
import com.assignment.model.Appointment;

/**
 * Servlet implementation class AppointmentServlet
 */
@WebServlet("/list3/*")
public class AppointmentServlet extends HttpServlet {	
private static final long serialVersionUID = 1L;

private AppointmentDao appDao;

public void init(ServletConfig config) throws ServletException {
	appDao = new AppointmentDao();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String action = request.getServletPath();
	System.out.println("action :" + action);
	try {
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		default:
			listUser(request, response);
			break;
		}
	} catch (SQLException ex) {
		throw new ServletException(ex);
	}
}

private void listUser(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException, ServletException {
	List<Appointment> listUser = appDao.selectAllUsers();
	request.setAttribute("listUser", listUser);
	RequestDispatcher dispatcher = request.getRequestDispatcher("appList.jsp");
	dispatcher.forward(request, response);
}

private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	RequestDispatcher dispatcher = request.getRequestDispatcher("appForm.jsp");
	dispatcher.forward(request, response);
}

private void insertUser(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
	String patientName = request.getParameter("patientName");
	String patientEmail = request.getParameter("patientEmail");
	String patientAge = request.getParameter("patientAge");
	String reason = request.getParameter("reason");
	String slot = request.getParameter("slot");
	String doctorName = request.getParameter("doctorName");
	String location = request.getParameter("location");
	Appointment newUser = new Appointment(patientName, patientEmail, patientAge, reason, slot, doctorName, location);
	appDao.insertAppointment(newUser);
	response.sendRedirect("/test/list");
}
}
