package models;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

public class Administrator {

    private List<String> auditLog;

    //admin can act like system and contain the tutors, students, and course list.
    private List<Tutor> tutorList;
    private List<Student> studentList;
    private List<Course> courseList;

    
    public Administrator() {
        auditLog = new ArrayList<>();

        tutorList = new ArrayList<>();
        studentList = new ArrayList<>();
        courseList = new ArrayList<>();
    }


    public void addStudent(String username, String password, int studentID) {
        Student student = new Student(username, password, studentID);
        studentList.add(student);

        logAction(String.format("Created student account for student ID: %d.", studentID));
    }


    public void addTutor(String username, String password, String name, float rating, List<Course> tutoringSubjects, List<Appointment> meetings) {
        Tutor tutor = new Tutor(username, password, name, rating, tutoringSubjects, meetings);
        tutorList.add(tutor);

        logAction(String.format("Created tutor account for %s.", name));
    }


    public void addCourse(String courseID, String topic) {
        Course course = new Course(courseID, topic);
        courseList.add(course);

        logAction(String.format("Created course for courseID: %s.", courseID));
    }


    public void manageCourse() {
        //this function may need to be split up or changed

        logAction("Managed Course List.");
    }


    public void approveTutor(Tutor tutor) {
        //need a tutor approval field or function!

        logAction(String.format("Approved tutor %s.", tutor.getName()));
    }


    public void assignTutor(Tutor tutor, Course course) {
        List<Course> tutoringSubjects;
        Boolean repeatCourse = false;

        if (tutor == null || course == null) {
            logAction("Failed to assign a tutor to a course!");
            throw new NullPointerException("Error: Tried to use a null pointer when assigning a tutor to a course!");
            return;
        }

        tutoringSubjects = tutor.getTutoringSubjects();

        for (Course tutorCourses : tutoringSubjects) {
            if (tutorCourses.equals(course)) {
                repeatCourse = true;
            }
        }

        if (repeatCourse == true) {
            logAction("Failed to assign a tutor to a course!");
            throw new Exception("Error: Tried to assign the tutor to a duplicate course!");
            return;
        }

        tutoringSubject.add(course);
        tutor.setTutoringSubjects(tutoringSubjects);

        logAction(String.format("Assigned tutor %s to course ID: %s.", tutor.getName(), course.getCourseID()));
    }


    public void viewReports() {
        //this may need to be split up to multiple functions

        logAction(String.format("Viewed Reports."));
    }

    
    public void deactivateAcc(Student student) {
        if (student == null) {
            logAction("Failed to deactivate a student account!");
            throw new NullPointerException("Error: Tried to use a null pointer deactivating a student account!");
            return;
        }

        int studentID = student.getStudentID();
        student.remove(student);

        logAction(String.format("Removed student with student ID: %d.", studentID));
    }


    private void logAction(String message) {
        String auditMessage = LocalDateTime.now() + ": " + message;
        auditLog.add(auditMessage);
    }


    public void printAuditLog() {
        System.out.println("Audit Log: ");

        for (String auditMessage : auditLog) {
            System.out.println(auditMessage);
        }
    }
}