import java.util.Scanner;

public class Main_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int cnt = 0;
		String str = sc.next();
		for(int i=0;i<str.length();i++) {
			cnt += (str.charAt(i))-48;
		}
		System.out.println(cnt);
		sc.close();
	}

}
