package models;

import java.time.LocalDateTime;

public class Notification {
	public String notificationID;
	public String message;
	public LocalDateTime sent;
	public String recipientUsername; // Note: Corrected spelling from UML's 'recepientUsername'

	// Constructor to initialize the models.Notification object
	public Notification(String notificationID, String message, LocalDateTime sent, String recipientUsername) {
		this.notificationID = notificationID;
		this.message = message;
		this.sent = sent;
		this.recipientUsername = recipientUsername;
	}

	public void sendConfirmation() {
		System.out.println("Confirmation sent to: " + recipientUsername);
	}

	public void sendReminder() {
		System.out.println("Reminder sent to: " + recipientUsername);
	}
}