import java.util.Scanner;

public class Main_11021 {
//	B5 A+B -7
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println("Case #" + (t + 1) + ": " + (A + B));
		}
		sc.close();
	}

}
