import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14510 {
	static int N;
	static int[] arr;
	static int time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			time = 0;
			solve();
			System.out.println("#" + (t + 1) + " " + time);
		}
	}

	private static void solve() {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		while (!check()) {
			time++;
			for (int i = 0; i < N; i++) {
				if (max > arr[i]) {
//					System.out.println(max + " " + arr[i]);
					if (time % 2 == 1 && max - 2 != arr[i]) {
						arr[i] += 1;
						break;
					} else if (time % 2 == 0 && arr[i] + 2 <= max) {
						arr[i] += 2;
						break;
					}
				}
			}
//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
		}

	}

	private static boolean check() {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
