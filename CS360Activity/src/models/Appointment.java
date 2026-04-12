package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private String appointmentID;
    private LocalDate date;
    private LocalTime time;
    private Course course;
    private String status;

    public Appointment(String appointmentID, LocalDate date, LocalTime time,
            Course course, String status) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.time = time;
        this.course = course;
        this.status = status;
    }

    // Getter methods
    public String getAppointmentID() {
        return appointmentID;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Course getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Setter methods
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setStatus(String status) {
        // validate status using one of the allowed values
        if (status.equals("Scheduled") || status.equals("Completed") || status.equals("Cancelled")) {
            this.status = status;
        } else {
            System.out.println("Invalid status. Use Scheduled, Completed, or Cancelled.");
        }
    }

    public void schedule() {
        this.status = "Scheduled";
        System.out.println("models.Appointment " + appointmentID + " has been scheduled.");
    }

    public void cancel() {
        this.status = "Cancelled";
        System.out.println("models.Appointment " + appointmentID + " has been cancelled.");
    }

    public void reschedule(LocalDate newDate, LocalTime newTime) {
        this.date = newDate;
        this.time = newTime;
        System.out.println("models.Appointment " + appointmentID + " rescheduled to " + newDate + " at " + newTime);
    }

    public boolean isAvailable() {
        return status == null || status.equals("Cancelled");
    }

    @Override
    public String toString() {
        return "models.Appointment: " +
                "\nappointmentID =" + appointmentID +
                "\ndate =" + date +
                "\ntime =" + time +
                "\ncourse = " + course.courseID +
                "\nstatus= " + status;
    }

}