package Collection_Programs;

import java.util.LinkedList;
import java.util.Scanner;

public class Assignment_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> recentApps = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Open app name: ");
            String app = sc.nextLine();

            // If already opened, remove it
            recentApps.remove(app);

            // Add to top
            recentApps.addFirst(app);
        }

        System.out.println("\nFinal Recent Apps:");
        for (String app : recentApps) {
            System.out.println(app);
        }



	}

}
