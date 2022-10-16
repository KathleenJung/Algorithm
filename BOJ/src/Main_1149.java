import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
	static int N;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 빨강, 초록, 파랑
		for (int i = 0; i < 3; i++) {
			dp[0][i] = map[0][i];
		}
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + map[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + map[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + map[i][2];
		}
		int min = Math.min(dp[N-1][0], dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		System.out.println(min);
	}

}
