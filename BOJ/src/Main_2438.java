import java.util.Scanner;

public class Main_2438 {

	public static void main(String[] args) {
//		B5 별 찍기 - 1
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
