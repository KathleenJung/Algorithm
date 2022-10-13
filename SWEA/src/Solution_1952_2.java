import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_2 {
	static int day, mon, mon3, year;
	static int[] plan;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			mon = Integer.parseInt(st.nextToken());
			mon3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			plan = new int[12];
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			min = year;
			solve(0, ans);
			System.out.println("#"+(t+1)+" "+min);
		}
		
	}
	private static void solve(int pos, int ans) {
		if(pos >= 12) {
			min = Math.min(min, ans);
			return;
		}
		
		solve(pos+1, ans + (plan[pos]*day));
		solve(pos+1, ans+mon);
		solve(pos+3, ans+mon3);
	}

}
