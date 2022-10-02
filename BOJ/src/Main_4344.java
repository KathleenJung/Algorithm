import java.util.Scanner;

public class Main_4344 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			double ans = 0;
			int cnt = 0;
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
				ans += arr[i];
			}
			ans /= N;
			for(int i=0;i<N;i++) {
				if(arr[i]>ans) {
					cnt++;
				}
			}
			System.out.printf("%.3f%%\n", ((double)cnt/N*100));
		}
		System.out.println(sb);
		sc.close();
	}

}
