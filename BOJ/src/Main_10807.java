import java.util.Scanner;

//B5 개수 세기
public class Main_10807 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		for (int i = 0; i < N; i++) {
			if (arr[i] == v) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
