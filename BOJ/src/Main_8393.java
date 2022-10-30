import java.util.Scanner;

public class Main_8393 {
//	B5 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += i;
		}
		System.out.println(ans);
		sc.close();
	}

}
