import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4193 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int[][] map;
	static int A, B, C, D;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			ans = -1;
			
			solve();
			
			System.out.println(ans);
		}
	}
	private static void solve() {
		Queue<Point> q = new ArrayDeque<>();
		visited = new boolean[N][N];
		visited[A][B] = true;
		int time = 0;
		q.offer(new Point(A, B));
		
		while(!q.isEmpty()) {
			time++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = p.x+delta[d][0];
					int ny = p.y + delta[d][1];
					if(nx>=0&&ny>=0&&nx<N&&ny<N&&(map[nx][ny]==0||(map[nx][ny]==2 && time %3 == 2))&&!visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
						System.out.println(nx + " " + ny);
						if(nx == C && ny == D) {
							ans = time;
							return;
						}
					}
				}
			}
		}
	}

}
