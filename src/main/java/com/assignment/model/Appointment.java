package com.assignment.model;

public class Appointment {
	
	private int id;
	private String patientName;
	private String patientEmail;
	private String patientAge;
	private String reason;
	private String slot;
	private String doctorName;
	private String location;
	private int doctorid;
	
	public Appointment() {
		
	}
	
	
	
	public Appointment(int id, String patientName, String patientEmail, String patientAge, String reason, String slot,
			String doctorName, String location, int doctorid) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientAge = patientAge;
		this.reason = reason;
		this.slot = slot;
		this.doctorName = doctorName;
		this.location = location;
		this.doctorid = doctorid;
	}



	public Appointment(String patientName, String patientEmail, String patientAge, String reason, String slot,
			String doctorName, String location, int doctorid) {
		super();
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientAge = patientAge;
		this.reason = reason;
		this.slot = slot;
		this.doctorName = doctorName;
		this.location = location;
		this.doctorid = doctorid;
	}



	public Appointment(int id, String patientName, String patientEmail, String patientAge, String reason, String slot,
			String doctorName, String location) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientAge = patientAge;
		this.reason = reason;
		this.slot = slot;
		this.doctorName = doctorName;
		this.location = location;
	}

	public Appointment(String patientName, String patientEmail, String patientAge, String reason, String slot,
			String doctorName, String location) {
		super();
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientAge = patientAge;
		this.reason = reason;
		this.slot = slot;
		this.doctorName = doctorName;
		this.location = location;
	}



	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
