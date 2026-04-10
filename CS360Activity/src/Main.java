import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//creating tutors
		Tutor ryan = new Tutor("ryan01", "alpha", "Ryan");
		Tutor nadia = new Tutor("nadia01", "beta", "Nadia");
		Tutor steve = new Tutor("steve01", "charlie", "Steve");

		//creating courses
		Course CS360 = new Course("CS360", "Software_Engineering");
		Course CS364 = new Course("CS364", "Intro_To_Data_Sys");
		Course CS380 = new Course("CS380", "Artifical_Intelligence");
		Course CS486 = new Course("CS486", "Analysis_Of_Algorithms");
		Course CS160 = new Course("CS160", "Intro_To_CS_pt1");
		Course CS161 = new Course("CS161", "Intro_To_CS_pt2");

		//Test code
	}
}