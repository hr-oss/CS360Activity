package models;

import java.time.LocalTime;
import java.util.*;

public class Tutor extends User {
	String name;
	float rating;
	List<Course> tutoringSubjects;
	List<Appointment> meetings;

	public Tutor(String username, String password, String name) {
		super(username, password);
		this.name = name;
		this.rating = rating;
		this.tutoringSubjects = new ArrayList<Course>();
		this.meetings = new ArrayList<Appointment>();
	}

	public Tutor(String username, String password, String name, float rating, List<Course> tutoringSubjects,
			List<Appointment> meetings) {
		super(username, password);
		this.name = name;
		this.rating = rating;
		this.tutoringSubjects = new ArrayList<Course>(tutoringSubjects);
		this.meetings = new ArrayList<Appointment>(meetings);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<Course> getTutoringSubjects() {
		return this.tutoringSubjects;
	}

	public void setTutoringSubjects(List<Course> newSubjects) {
		this.tutoringSubjects = new ArrayList<Course>(newSubjects);
	}

	public boolean availability(Appointment appointment) {
		LocalTime time = appointment.getTime();
		int hour = time.getHour();

		if (hour < 9 || hour > 20) { // Between 9a-5p
			System.out.println("Outside of working hours!");
			return false;
		}

		if (!(this.meetings.contains(appointment)) &&
				this.tutoringSubjects.contains(appointment.getCourse()) &&
				appointment.isAvailable()) {
			return true;
		}

		return false;
	}

	public void acceptMeeting(Appointment appointment) {
		if (availability(appointment)) {
			this.meetings.add(appointment);
		}
	}

	public void cancelMeeting(Appointment meeting) {
		meeting.cancel();
		this.meetings.remove(meeting);
	}

	@Override
	public String toString() {
		return getName() + ":\n"
				+ "\tRating: " + getRating() + "\n"
				+ "\tSubjects: " + getTutoringSubjects() + "\n";
	}
}