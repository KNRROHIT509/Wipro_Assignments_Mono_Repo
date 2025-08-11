package com.Solid;
//Abstraction (interface)
interface MessageService {
 void sendMessage(String msg, String rec);
}

//Low-level module implementing abstraction
class EmailService implements MessageService {
 @Override
 public void sendMessage(String msg, String rec) {
     System.out.println("Sending email to " + rec + ": " + msg);
 }
}

//Another low-level module
class SmsService implements MessageService {
 @Override
 public void sendMessage(String msg, String rec) {
     System.out.println("Sending SMS to " + rec + ": " + msg);
 }
}

//High-level module depending on abstraction
class NotificationManager {
 private MessageService msgser;
 
 // Dependency injected through constructor
 public NotificationManager(MessageService msgser) {
     this.msgser = msgser;
 }
 
 public void sendNotification(String msg, String rec) {
     msgser.sendMessage(msg, rec);
 }
}

//Usage
public class Dependency_Inversion_Principle {
 public static void main(String[] args) {
     // Can easily switch between implementations
     MessageService es = new EmailService();
     NotificationManager en = new NotificationManager(es);
     en.sendNotification("Hello via email", "user@example.com");
     
     MessageService ss = new SmsService();
     NotificationManager sn = new NotificationManager(ss);
     sn.sendNotification("Hello via SMS", "+1234567890");
 }
}