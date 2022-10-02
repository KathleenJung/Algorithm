
import java.util.Scanner;

public class Main_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		int s = sc.nextInt();
		for(int i=0;i<s;i++) {
			int g = sc.nextInt();
			int num = sc.nextInt();
			
			if(g == 1) {
				for(int idx=1;idx<=n;idx++) {
					if(idx%num == 0) {
						if(arr[idx] == 1) {
							arr[idx] = 0;
						}
						else {
							arr[idx] = 1;
						}
					}
				}
			}
			else if(g==2) {
				if(arr[num] == 1) {
					arr[num] = 0;
				}
				else {
					arr[num] = 1;
				}
				int j = 1;
				while(num-j>=1 && num+j<=n) {
					if(arr[num-j] == arr[num+j]) {
						if(arr[num-j] == 1) {
							arr[num-j] = 0;
							arr[num+j] = 0;
						}
						else {
							arr[num-j] = 1;
							arr[num+j] = 1;
						}
						j++;
					} else {
						break;
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.print(arr[i] + " ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
		sc.close();
	}

}
