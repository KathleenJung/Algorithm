// Programmers [코딩테스트 입문] 026. 직각삼각형 출력하기

import java.util.Scanner;

public class Solution_026 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

//        System.out.println(n);
        sc.close();
    }

}
