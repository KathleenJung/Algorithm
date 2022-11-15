import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D4 1486. 장훈이의 높은 선반
public class Solution_1486 {
	static int N, B;
	static int[] H;
	static int ans;
	static int top;
	static boolean[] isSelected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			H = new int[N];
			top = 0;
			isSelected = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			subset(0);
			System.out.println("#" + (t + 1) + " " + (top - B));
		}
	}

	private static void subset(int pos) {
		if (pos == N) {
			ans = 0;
//			for (int i = 0; i < N; i++) {
//				System.out.print(isSelected[i] ? H[i] : "x");
//				System.out.print(" ");
//			}
//			System.out.println();
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					ans += H[i];
				}
			}

//			System.out.println(ans);
			if (ans >= B && (Math.abs(top - B) > Math.abs(ans - B))) {
//				System.out.println(ans);
				top = ans;
			}
			return;
		}

		isSelected[pos] = true;
		subset(pos + 1);
		isSelected[pos] = false;
		subset(pos + 1);
	}

}
