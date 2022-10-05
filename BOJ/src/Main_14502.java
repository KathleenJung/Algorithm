import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] arr;
	static int[][] temp;
	static boolean[][] visited;
	static int safe;
	static int max;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		temp = new int[N][M];
		comb(0);

		System.out.println(max);
	}

	private static void comb(int cnt) {

		if (cnt == 3) {
			copy(temp, arr);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 2) {
						bfs(i, j);
					}
				}
			}

//			print(temp);

			safe = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp[i][j] == 0) {
						safe++;
					}
				}
			}
			max = Math.max(max, safe);

			return;
		}

		// i=0
		for (int i = 0; i < N; i++) {
			// j=1
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
//					print(temp);
//					System.out.println("뽑은 좌표 = " + i + " " + j);
					arr[i][j] = 1;
					comb(cnt + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	private static void copy(int[][] temp2, int[][] arr2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp2[i][j] = arr2[i][j];
			}
		}
	}

	private static void print(int[][] array) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs(int x, int y) {
		visited = new boolean[N][M];
		Queue<Point> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new Point(x, y));
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + delta[d][0];
				int ny = p.y + delta[d][1];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && temp[nx][ny] == 0) {
					visited[nx][ny] = true;
					temp[nx][ny] = 2;
					q.offer(new Point(nx, ny));
				}
			}
		}
	}
}