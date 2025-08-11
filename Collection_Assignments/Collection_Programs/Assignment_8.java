package Collection_Programs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Assignment_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int last_search=4;
		int n=sc.nextInt();
		ArrayDeque<String> chatBox=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			if(chatBox.size()==last_search) {
				chatBox.removeFirst();
			}
			chatBox.add(sc.next());
		}
		System.out.println(chatBox);

	}

}
