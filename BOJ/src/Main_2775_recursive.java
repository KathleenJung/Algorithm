import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_recursive {
	static int[][] dp;
	static int K, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		B1 부녀회장이 될테야
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			K = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			dp = new int[K + 1][N + 1];

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
			if(dp[K][N] == 0) {
				rec(k, n);
			}
			System.out.println(dp[K][N]);
		}
	}

	private static void rec(int k, int n) {
		if(dp[k][n] == 0) {
			rec(k-1, n);
		} else {
			dp[k+1][n] = dp
		}
	}

}
