import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// G5 머리 톡톡
public class Main_1241 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < N; i++) {
			int temp = arr[i];
			arr[i] = 0;
			for (int j = 0; j < N; j++) {
				if(j!=i) {
					if(temp%arr[j] == 0) {
//						System.out.println(arr[i] + " " + arr[j]);
						arr[i]++;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
