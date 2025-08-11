package Collection_Programs;

import java.util.PriorityQueue;
import java.util.Comparator;

class Job {
    String name;
    int urgency; // 1 = most urgent, 5 = least urgent

    public Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return name + " (Urgency: " + urgency + ")";
    }
}

public class Assignment_7 {
    public static void main(String[] args) {
        Comparator<Job> jobComparator = (j1, j2) -> {
            if (j1.urgency != j2.urgency) {
                return Integer.compare(j1.urgency, j2.urgency);
            }
            return Integer.compare(j1.name.length(), j2.name.length());
        };

        PriorityQueue<Job> job = new PriorityQueue<>(jobComparator);

        job.add(new Job("WriteReport", 3));
        job.add(new Job("FixBug", 1));
        job.add(new Job("Test", 1));
        job.add(new Job("DesignUI", 2));
        job.add(new Job("UpdateDocs", 3));

        System.out.println("Jobs in processing order:");
        while (!job.isEmpty()) {
            System.out.println(job.poll());
        }
    }
}