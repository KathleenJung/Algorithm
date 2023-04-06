import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458 {

	static int N;
	static int arr[];
	static int B, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		long ans = 0;

		for (int i = 0; i < N; i++) {
			ans += 1;
			if (arr[i] > B) {
				arr[i] -= B;
				ans += arr[i] / C;
				if (arr[i] % C != 0) {
					ans += 1;
				}
			}
		}

		System.out.println(ans);
	}

}
