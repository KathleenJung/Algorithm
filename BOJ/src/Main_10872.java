import java.util.Scanner;

public class Main_10872 {
	static int ans;

//	B5 팩토리얼
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ans = 1;
		System.out.println(fac(N));
		sc.close();
	}

	private static int fac(int n) {
		if (n == 0) {
			ans = 1;
			return ans;
		}
		if (n == 1) {
			return ans;
		}
		return ans = n * fac(n - 1);
	}

}
