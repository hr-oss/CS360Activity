import java.util.*;

class Tutor extends User{
String username;
String name;
float rating;
List<Course> tutoringSubjects;
List<Date> meetings;

public Tutor(String username, String name, float rating, List<Course> tutoringSubjects, List<Date> meetings){
    Super(username, name);
    this.rating = rating;
    this.tutoringSubjects = new ArrayList<Course>(tutoringSubjects);
    this.meetings = new ArrayList<Date>(meetings);
}

public float getRating(){
    return this.rating;
}

public void setRate(float rating){
    this.rating = rating;
}

public List<Course> getTutoringSubjects(){
    return this.tutoringSubjects;
}

public void setTutoringSubjects(List<Course> newSubjects){
    this.tutoringSubjects = new ArrayList<Course>(newSubjects);
}

public void setAvailability(){

}

public void acceptMeeting(){

}

public void declineMeeting(){

}

public void cancelMeeting(){

}

}