

import java.util.Scanner;

public class Main_3040 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 9;
		int[] arr = new int[size];
		int sum = 0;
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sum -= 100;

		int index = 0, index2 = 0;
		Loop:
			for(int i=0;i<8;i++) {
				for(int j=1;j<9;j++) {
					if(sum == arr[i] + arr[j]) {
						index = i;
						index2 = j;
						break Loop;
					}
				}
			}
		for(int i=0;i<9;i++) {
			if(i==index || i==index2) {
				continue;
			} else {
				System.out.println(arr[i]);
			}
		}
		sc.close();
	}

}
