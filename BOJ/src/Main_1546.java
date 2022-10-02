import java.util.Scanner;

public class Main_1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int M = Integer.MIN_VALUE;
		double ans = 0;
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
			M = Math.max(M, arr[i]);
		}
		for(int i=0;i<N;i++) {
			double temp;
			temp = (double)arr[i] / M * 100;
			ans += temp;
		}
		System.out.println(ans/N);
		sc.close();
	}

}
