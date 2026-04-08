import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Tutoring System CLI!");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create a new Course");
            System.out.println("2. Send a Notification");
            System.out.println("3. Exit");
            System.out.print("What would you like to do? (Enter a number): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Course ID (e.g., CS360): ");
                    String courseId = scanner.nextLine();

                    System.out.print("Enter Course Topic: ");
                    String topic = scanner.nextLine();

                    // Instantiate the object using the user's input
                    Course newCourse = new Course(courseId, topic);
                    System.out.println("Boom boom! Course created: " + newCourse.courseID + " - " + newCourse.topic);
                    break;

                case "2":
                    System.out.print("Enter Recipient Username: ");
                    String user = scanner.nextLine();

                    System.out.print("Enter Notification Message: ");
                    String msg = scanner.nextLine();

                    // Instantiate the notification using the user's input
                    Notification notif = new Notification(
                            "NOTIF-001",
                            msg,
                            LocalDateTime.now(),
                            user
                    );

                    System.out.println("Sending...");
                    notif.sendConfirmation();
                    notif.sendReminder();
                    break;

                case "3":
                    System.out.println("Shutting down... See ya, goober!");
                    running = false; // This breaks the loop
                    break;

                default:
                    System.out.println("Invalid choice. I suppose you should try typing 1, 2, or 3!");
            }
        }

        // Always close your scanner to prevent resource leaks!
        scanner.close();
    }
}