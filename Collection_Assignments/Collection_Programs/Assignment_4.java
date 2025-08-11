package Collection_Programs;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Assignment_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack<String> commands =new Stack<>();
		for(int i=0;i<3;i++) {
			commands.push(sc.next());
		}
		String store=commands.pop();
		Collections.reverse(commands);
		commands.push(store);
		System.out.println(commands);
	}

}
