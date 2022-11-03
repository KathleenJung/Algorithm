import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2775_TopDown {
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

			for (int i = 1; i <= K; i++) {
				int sum = dp[i - 1][0];
				for (int j = 0; j <= N; j++) {
					sum += dp[i - 1][j];
					dp[i][j] = sum;
				}
			}
			rec(K, N);
			System.out.println(dp[K][N]);
		}
	}

	private static int rec(int k, int n) {
		// 기저 조건
		if (k == 0) {
			return n;
		}
		
		// 값이 있으면 계산하지 않고 바로 넘겨주기
		if (dp[k][n] != 0) {
			return dp[k][n];
		}
		
		// 값이 없으면 계산하기
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += rec(k - 1, i);
		}
		
		// 배열의 값을 저장함과 동시에 리턴하기
		return dp[k][n] = sum;
	}

}
