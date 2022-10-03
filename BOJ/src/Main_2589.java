
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

		int max = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'L') {
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(visited[i][j] == true ? 1 : 0);
//			}
//			System.out.println();
//		}
		
		System.out.println(max-1);
		
//		System.out.println(bfs(1,1));

	}

	private static int bfs(int x, int y) {
		int cnt = 0;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(x, y));
		visited = new boolean[R][C];
		visited[x][y] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point temp;
				temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = temp.x + delta[d][0];
					int ny = temp.y + delta[d][1];
					if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny] && map[nx][ny] == 'L') {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
			cnt++;
		}
		return cnt;
	}

}
