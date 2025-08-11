package Collection_Programs;

import java.util.concurrent.LinkedBlockingQueue;

public class Assignment_10 {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> chatQueue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            int count = 1;
            try {
                while (true) {
                    String msg = "Message " + count++;
                    chatQueue.put(msg);
                    System.out.println("[Producer] Added: " + msg);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String msg = chatQueue.take();
                    System.out.println("   [Consumer] Read: " + msg);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}