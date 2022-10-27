import java.util.Arrays;
import java.util.Scanner;

public class Main_5597 {
//B5 과제 안 내신 분..? 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] arr = new boolean[31];
		for (int i = 1; i <= 28; i++) {
			int idx = sc.nextInt();
			arr[idx] = true;
		}
		int[] array = new int[2];
		int idx = 0;
		for (int i = 1; i <= 30; i++) {
			if(!arr[i]) {
				array[idx] = i;
				idx++;
			}
		}
		Arrays.sort(array);
		System.out.println(array[0]);
		System.out.println(array[1]);
		sc.close();
	}

}
