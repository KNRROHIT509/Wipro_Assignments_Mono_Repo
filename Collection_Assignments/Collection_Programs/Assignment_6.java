package Collection_Programs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Assignment_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayDeque<String> names=new ArrayDeque<>();
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			String st=sc.next();
			if(st.length()%2==0) {
				names.addFirst(st);
			}
			else {
				names.addLast(st);
			}
		}
		System.out.println(names);
	}

}
