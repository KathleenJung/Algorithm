

import java.util.Scanner;

public class Solution_9229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			int max = -1;
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					sum = arr[i] + arr[j];
					if(sum<=M && max<sum)
						max = sum;
				}
			}
			sb.append("#").append(t).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

}