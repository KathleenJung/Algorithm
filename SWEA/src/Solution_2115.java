import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115 {
	static int N; // 벌통 N*N
	static int M; // 가로로 M개 선택해서 벌꿀 채취
	static int C; // 채취할 수 있는 꿀의 최대 양
	static int[][] map;
	static int ans;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M; j++) {
					solve(i, j);
				}
			}
			System.out.println("#" + (t + 1) + " " + ans);
		}
	}

	private static void comb(int cnt) {
		if (cnt == 2) {

		}
	}
	
	private static void solve(int x, int y) {
		for (int j = 0; j < M; j++) {
			visited[x][y + j] = true;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M; j++) {
				if (!visited[i][j - M]) {

				}
			}
		}
	}

}
