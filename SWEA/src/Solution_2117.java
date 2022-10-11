import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2117 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M; // M = 하나의 집이 지불할 수 있는 비용
	static int[][] map;
	static int max;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = -1;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					visited = new boolean[N][N];
					solve(i, j);
				}
			}

			System.out.println("#" + (t + 1) + " " + max);
		}
	}

	private static void solve(int x, int y) {
		int K = 1;
		int amount = K * K + (K - 1) * (K - 1);
		int money = 0;

		Queue<Point> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new Point(x, y));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				if (map[p.x][p.y] == 1) {
					money += M;
				}
				for (int d = 0; d < 4; d++) {
					int nx = p.x + delta[d][0];
					int ny = p.y + delta[d][1];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			amount = K * K + (K - 1) * (K - 1);
			if (amount <= money) {
				max = Math.max(max, money / M);
			}
			K++;
//			System.out.println(money/M + " " + amount + " " + money + " " + max);
			
		}
	}

}
