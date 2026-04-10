import java.util.*;

class Tutor extends User{
    String name;
    float rating;
    List<Course> tutoringSubjects;
    List<Appointment> meetings;

    public Tutor(String username, String password, String name, float rating, List<Course> tutoringSubjects, List<Appointment> meetings){
        super(username, password);
        this.name = name;
        this.rating = rating;
        this.tutoringSubjects = new ArrayList<Course>(tutoringSubjects);
        this.meetings = new ArrayList<Appointment>(meetings);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    public float getRating(){
        return this.rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    public List<Course> getTutoringSubjects(){
        return this.tutoringSubjects;
    }

    public void setTutoringSubjects(List<Course> newSubjects){
        this.tutoringSubjects = new ArrayList<Course>(newSubjects);
    }

    // public void setAvailability(){

    // }

    public void acceptMeeting(Course course, Appointment appointment){
        if (!(this.meetings.contains(appointment)) && this.tutoringSubjects.contains(course) && appointment.isAvailable()){
            this.meetings.add(appointment);
        }
    }

    public void cancelMeeting(Appointment meeting){
        meeting.cancel();
        this.meetings.remove(meeting);
    }

    public String toString(){
        return getName() + ":\n"
            + "\tRating: " + getRating() + "\n"
            + "\tSubjects: " + getTutoringSubjects() + "\n";
    }
}