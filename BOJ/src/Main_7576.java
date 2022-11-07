import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
//	BOJ G5 토마토
	static int M, N;
	static int[][] arr;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cnt;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}
		cnt = 0;
		tomato();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					cnt = -1;
				}
			}
		}
		System.out.println(cnt == -1 ? -1 : cnt - 1);
	}

	private static void tomato() {
		while (!q.isEmpty()) {
			cnt++;
//			System.out.println(q.size());
			int size = q.size();

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = p.x + delta[d][0];
					int ny = p.y + delta[d][1];
					if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
	}

}
