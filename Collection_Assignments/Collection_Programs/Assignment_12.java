package Collection_Programs;

import java.util.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Comparator;

import java.time.LocalDateTime;

class Patient {
    private String name;
    private int severity; // 1-10, 1 is most severe
    private LocalDateTime arrivalTime;
    
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = LocalDateTime.now();
    }
    
    public String getName() { return name; }
    public int getSeverity() { return severity; }
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    
    @Override
    public String toString() {
        return name + " (Severity: " + severity + 
               ", Arrived: " + arrivalTime.toLocalTime() + ")";
    }
}

public class Assignment_12 {
    private static final int MAX_QUEUE_SIZE = 5;
    private PriorityQueue<Patient> patientQueue;
    
    public Assignment_12() {
        // Custom comparator: first by severity, then by arrival time
        Comparator<Patient> patientComparator = Comparator
            .comparingInt(Patient::getSeverity)
            .thenComparing(Patient::getArrivalTime);
            
        this.patientQueue = new PriorityQueue<>(patientComparator);
    }
    
    public boolean addPatient(Patient patient) {
        if (patientQueue.size() >= MAX_QUEUE_SIZE) {
            System.out.println("Queue is full! Cannot add more patients.");
            return false;
        }
        patientQueue.add(patient);
        System.out.println("Added: " + patient);
        return true;
    }
    
    public Patient treatNextPatient() {
        if (patientQueue.isEmpty()) {
            System.out.println("No patients in queue.");
            return null;
        }
        Patient nextPatient = patientQueue.poll();
        System.out.println("Treating: " + nextPatient);
        return nextPatient;
    }
    
    public void displayQueue() {
        System.out.println("\nCurrent Patient Queue:");
        if (patientQueue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        // Create a temporary copy to display without removing
        PriorityQueue<Patient> tempQueue = new PriorityQueue<>(patientQueue);
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Assignment_12 tracker = new Assignment_12();
        
        tracker.addPatient(new Patient("Vinay", 3));
        Thread.sleep(100); // Simulate time between arrivals
        tracker.addPatient(new Patient("Suresh", 2));
        Thread.sleep(100);
        tracker.addPatient(new Patient("Ramesh", 3));
        Thread.sleep(100);
        tracker.addPatient(new Patient("Tina", 1));
        Thread.sleep(100);
        tracker.addPatient(new Patient("Dinesh", 4));
        Thread.sleep(100);
        tracker.addPatient(new Patient("Vikas", 2)); // Should be rejected
        
        tracker.displayQueue();
        
        // Treat patients in correct order
        System.out.println("\nTreating patients:");
        while (tracker.treatNextPatient() != null) {
            // Treatment happens in the method
        }
    }
}