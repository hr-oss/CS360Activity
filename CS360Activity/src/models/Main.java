package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
	private static List<Tutor> tutors = new ArrayList<>();
	private static List<Student> students = new ArrayList<>();
	private static Course cs360 = new Course("CS360", "Software Engineering");

	public static void main(String[] args) {
		setupInitialData();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n--- CS360 Tutoring System Portal ---");
			System.out.println("1. Login as Student");
			System.out.println("2. Login as Tutor");
			System.out.println("3. Exit");
			System.out.print("Select role: ");

			String roleChoice = scanner.nextLine();
			if (roleChoice.equals("3")) break;

			if (roleChoice.equals("1")) {
				handleStudentFlow(scanner);
			} else if (roleChoice.equals("2")) {
				handleTutorFlow(scanner);
			} else {
				System.out.println("That ain't an option, goof!");
			}
		}
		System.out.println("System shutting down. Fare well!");
	}

	private static void handleStudentFlow(Scanner scanner) {
		Student currentStudent = students.get(0);
		boolean back = false;

		while (!back) {
			System.out.println("\n--- Student Menu (" + currentStudent.getUsername() + ") ---");
			System.out.println("1. View Tutors & Their Availability");
			System.out.println("2. Schedule Meeting");
			System.out.println("3. View My Meetings");
			System.out.println("4. Logout");
			System.out.print("Choice: ");

			String choice = scanner.nextLine();
			switch (choice) {
				case "1":
					System.out.println("\n--- Available Tutors ---");
					for (Tutor t : tutors) {
						System.out.println(t.getName() + " (Rating: " + t.getRating() + ")");
						System.out.println("   Current Bookings:");
						if (t.meetings.isEmpty()) {
							System.out.println("   [No current bookings - wide open!]");
						} else {
							t.meetings.forEach(m -> System.out.println("   - " + m.getDate() + " at " + m.getTime()));
						}
					}
					break;

				case "2":
					System.out.print("How many days from now would you like to book? ");
					int daysOut = Integer.parseInt(scanner.nextLine());
					System.out.print("What hour? (e.g., 14 for 2 PM): ");
					int hour = Integer.parseInt(scanner.nextLine());

					LocalDate chosenDate = LocalDate.now().plusDays(daysOut);
					LocalTime chosenTime = LocalTime.of(hour, 0);

					// Create the appointment with a NULL status so it passes the isAvailable() check
					Appointment newAppt = new Appointment(
							"APP" + System.currentTimeMillis(),
							chosenDate,
							chosenTime,
							cs360,
							null
					);
					System.out.println("\nAttempting to book with " + tutors.get(0).getName() + "...");
					System.out.println(currentStudent.scheduleAppointment(newAppt, tutors.get(0)));
					break;

				case "3":
					currentStudent.viewAppointments();
					break;
				case "4":
					back = true;
					break;
			}
		}
	}

	private static void handleTutorFlow(Scanner scanner) {
		Tutor currentTutor = tutors.get(0);
		boolean back = false;

		while (!back) {
			System.out.println("\n--- Tutor Menu (" + currentTutor.getName() + ") ---");
			System.out.println("1. View My Schedule");
			System.out.println("2. Cancel a Meeting");
			System.out.println("3. Logout");
			System.out.print("Choice: ");

			String choice = scanner.nextLine();
			switch (choice) {
				case "1":
					System.out.println("\n--- Your Upcoming Meetings ---");
					if (currentTutor.meetings.isEmpty()) {
						System.out.println("You're free as a bird!");
					} else {
						currentTutor.meetings.forEach(System.out::println);
					}
					break;
				case "2":
					if (!currentTutor.meetings.isEmpty()) {
						Appointment toCancel = currentTutor.meetings.get(0);
						currentTutor.cancelMeeting(toCancel);
						System.out.println("Cancelled your next meeting.");
					} else {
						System.out.println("Nothing to cancel!");
					}
					break;
				case "3":
					back = true;
					break;
			}
		}
	}

	private static void setupInitialData() {
		Tutor steve = new Tutor("dr_v", "pass", "Dr. V.", 4.99f,
				Collections.singletonList(cs360), new ArrayList<>());
		tutors.add(steve);
		students.add(new Student("student_jimmy", "pass", 101));
	}
}