import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008 {
	static int N; // 숫자 수, 연산자:N-1개
	static int[] num;
	static int[] op;
	static int ans;
	static int min, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			op = new int[4];
			ans = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			solve(1, num[0]);
			System.out.println("#" + (t+1) + " " + Math.abs(max - min));
		}
	}
	private static void solve(int pos, int ans) {
		if(pos==N) {
			min = Math.min(ans, min);
			max = Math.max(ans, max);
			return;
		}
//		System.out.println("결과 = " + ans);
		if(op[0] != 0) {
			op[0]--;
//			System.out.println("더하기" + num[pos] + " " + pos);
			solve(pos+1, ans+num[pos]);
			op[0]++;
		}
		if(op[1] !=0) {
			op[1]--;
//			System.out.println("빼기" + num[pos] + " " + pos);
			solve(pos+1, ans-num[pos]);
			op[1]++;
		}
		if(op[2] !=0) {
			op[2]--;
//			System.out.println("곱하기" + num[pos] + " " + pos);
			solve(pos+1, ans*num[pos]);
			op[2]++;
		}
		if(op[3] !=0) {
			op[3]--;
//			System.out.println("나누기" + num[pos] + " " + pos);
			solve(pos+1, ans/num[pos]);
			op[3]++;
		}
	}

}
