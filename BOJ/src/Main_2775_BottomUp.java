import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_BottomUp {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		B1 부녀회장이 될테야
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[K + 1][N + 1];

			for (int i = 0; i <= N; i++) {
				dp[0][i] = i;
			}

			for (int i = 1; i <= K; i++) {
				int sum = dp[i - 1][0];
				for (int j = 0; j <= N; j++) {
					sum += dp[i - 1][j];
					dp[i][j] = sum;
				}
			}
//			for (int i = 0; i <= K; i++) {
//				for (int j = 0; j <= N; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(dp[K][N]);
		}
	}

}
