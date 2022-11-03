import java.util.Scanner;

public class Main_10952 {

//	B5 A+B - 5
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A, B;
		while (true) {
			A = sc.nextInt();
			B = sc.nextInt();
			if (A == 0 && B == 0) {
				break;
			}
			System.out.println(A + B);
		}
		sc.close();
	}

}
