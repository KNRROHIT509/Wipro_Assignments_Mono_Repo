package Collection_Programs;

import java.util.*;
public class Assignment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[5];
		for(int i=0;i<5;i++) {
			arr[i]=sc.nextInt();
		}
		int sum=0;
		for(int i=0;i<5;i++) {
			if(arr[i] <10) {
				arr[i]=arr[i]*2;
				sum+=arr[i];
			}
			else {
				sum+=arr[i];
			}
		}
		double avg=sum/5;
		System.out.println(avg);
		
	}

}
