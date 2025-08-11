package Collection_Programs;

import java.util.concurrent.ArrayBlockingQueue;

public class Assignment_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jobs_allowed=3;
		ArrayBlockingQueue<String> jobs=new ArrayBlockingQueue<>(jobs_allowed);
		jobs.add("tea");
		jobs.add("burger");
		jobs.add("juice");
		jobs.remove("tea");
		jobs.add("coffee");
		System.out.println(jobs);
		

	}

}
