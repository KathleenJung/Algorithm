import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952 {
	static int day, mon, mon3, year;
	static int[] monthly;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1일, 1달, 3달, 1년

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			mon = Integer.parseInt(st.nextToken());
			mon3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			monthly = new int[12];
			for (int i = 0; i < monthly.length; i++) {
				monthly[i] = Integer.parseInt(st.nextToken());
			}

			min = year;
			mon3Cal(0,  0);
			System.out.println("#" + (t+1) + " " + min);
		}
	}

	private static void mon3Cal(int m, int sum) {
		if(m>=12) {
			min = Math.min(sum, min);
			return;
		}
		
		if(monthly[m] != 0) {
			mon3Cal(m+1, sum+mon);
			mon3Cal(m+1, sum+day*(monthly[m]));
			mon3Cal(m+3, sum+mon3);
		}
		else {
			mon3Cal(m+1, sum);
		}
	}
}
