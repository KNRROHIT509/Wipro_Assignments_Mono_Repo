package Collection_Programs;

import java.util.concurrent.*;

//Task class
class Task {
 int id;

 Task(int id) {
     this.id = id;
 }

 public int getId() {
     return id;
 }

 public String toString() {
     return "Task-" + id;
 }
}

public class Assignment_11 {
 static LinkedBlockingQueue<Task> stage1 = new LinkedBlockingQueue<>();
 static LinkedBlockingQueue<Task> stage2 = new LinkedBlockingQueue<>();

 public static void main(String[] args) {
     for (int i = 1; i <= 10; i++) {
         stage1.add(new Task(i));
     }

     Thread stage1Processor = new Thread(() -> {
         try {
             while (!stage1.isEmpty()) {
                 Task task = stage1.take(); 
                 System.out.println("Stage 1 processing: " + task);

                 if (task.getId() % 2 == 0) {
                     stage2.put(task); 
                 }
             }
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     });

     Thread stage2Processor = new Thread(() -> {
         try {
             while (true) {
                 Task task = stage2.poll(2, TimeUnit.SECONDS); 
                 if (task == null) break; 

                 System.out.println("Stage 2 processing: " + task);
             }
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     });

     // 4. Start both threads
     stage1Processor.start();
     stage2Processor.start();

     // 5. Wait for both to finish
     try {
         stage1Processor.join();
         stage2Processor.join();
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     System.out.println("All tasks processed.");
 }
}
