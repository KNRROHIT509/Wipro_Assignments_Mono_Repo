package Collection_Programs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Assignment_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int last_search=3;
		int n=sc.nextInt();
		ArrayDeque<String> searchBox=new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			if(searchBox.size()==last_search) {
				searchBox.removeFirst();
			}
			searchBox.add(sc.next());
		}
		System.out.println(searchBox);

	}

}
