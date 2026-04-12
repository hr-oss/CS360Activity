package models;

import java.util.ArrayList;

public class Student extends User {
    private int studentID;
    //needs appointment array to store appointments with tutors.
    private ArrayList<Appointment> appointments;

    public Student(String username, String password, int studentID) {
        super(username, password);
        this.studentID = studentID;
        this.appointments = new ArrayList<Appointment>();
        /* initialize appointment array */

    }

    public int getStudentID() {
        return studentID;
    }
    
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return super.toString() + "\nmodels.Student ID: " + studentID;
    }

    public String scheduleAppointment(Appointment appointment, Tutor tutor) {
        //given an appointment object, will schedule an appointment between a
        //student and tutor object. models.Tutor's check availability method will
        //return t or f. If t, appointment will be added to tutor's schedule
        //array and return a confirmation message. Otherwise, return a message
        //indicating the tutor is unavailable at that time.
        if (tutor.availability(appointment)) {
            tutor.acceptMeeting(appointment);
            this.appointments.add(appointment);
            return "models.Appointment scheduled successfully.";
        }
        return "models.Tutor is unavailable at that time. Try again.";
    }

    public String cancelAppointment(Appointment appointment, Tutor tutor) {
        //given an appointment object, will cancel the appointment between a
        //student and tutor object. models.Appointment will be removed from tutor's
        //schedule array and return a confirmation message.
        tutor.cancelMeeting(appointment);
        return "models.Appointment canceled successfully.";
    }

    public void viewAppointments() {
        //will return a list of the student's past and upcoming appointments with tutors.
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }

   


}
