import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014 {
	static int N, X;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = 0;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve();
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			System.out.println("#" + (t+1) + " " + ans);
		}
	}
	private static void solve() {
		
	}

}
