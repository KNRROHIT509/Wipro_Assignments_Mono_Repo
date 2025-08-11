package Collection_Programs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Assignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		LinkedList<String> ll=new LinkedList<>();
		int tasks_entered=4;
		for(int i=0;i<tasks_entered;i++) {
			String st=sc.next();
			if(st.charAt(st.length()-1)=='!') {
				ll.addFirst(st);
			}
			else
				ll.add(st);
		}
		Collections.reverse(ll);
		System.out.println(ll);
		
		
		
	}

}
