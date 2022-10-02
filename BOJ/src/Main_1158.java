

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			arr.add(i+1);
		}
		int index=K-1;
		System.out.print("<");
		for(int i=0;i<N;i++) {
			if(i==N-1) {
				System.out.println(arr.get(index)+">");
				break;
			}
			System.out.print(arr.get(index) + ", ");
			arr.remove(index);
			index = (index + K - 1) % arr.size();
		}
	}

}
