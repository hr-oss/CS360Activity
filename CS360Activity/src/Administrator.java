public class Administrator {

    public String username = "admin";
    public String password = "admin123";

    
    public boolean validateLogin(String username, String password) {
        return (this.username.equals(username) && this.password.equals(password));
    }

    public void manageCourse() {
        //what do I do here this is too broad
    }

    /*
    public Tutor createTutorAcc(Float rating, List subjects) {
        Tutor tutor = new Tutor(rating, subjects);
        return tutor;
    }
    */

    /*
    public void deactivateAcc(Student student) {
        student = null;
    }
    */

    public void viewReports() {
        //what does this mean
    }

}