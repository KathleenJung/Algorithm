import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844 {
//	S1 쉬운 계단 수
	static int N;
	static int[][] dp;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ans = 0;
//		(자기 자신의 수 -1의 개수) + (자기 자신의 수 + 1의 개수)
		for (int i = 0; i <= 9; i++) {
			ans += dp[N][i];
		}
		
	}

}
