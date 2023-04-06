import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683 {

	static class Point {

		int x, y, type;

		public Point(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
		}

	}

	static int N;
	static int M;
	static int[][] arr;
	static int[][] result;
	static ArrayList<Point> cctv;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		result = new int[N][M];
		cctv = new ArrayList<Point>();
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					cctv.add(new Point(i, j, arr[i][j]));
				}
			}
		}
		copyMap(arr, result);
		tv(0, result);

		System.out.println(min);
	}

	private static void tv(int cnt, int[][] temp) {
		if (cnt == cctv.size()) {
			min = Math.min(min, count(temp));
			return;
		}

		int dx = cctv.get(cnt).x;
		int dy = cctv.get(cnt).y;
		int[][] map = new int[N][M];

		if (arr[dx][dy] == 1) {
			// 상하좌우
			copyMap(temp, map);
			view(map, dx, dy, 1);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 2);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 3);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);
		} else if (arr[dx][dy] == 2) {
			// 좌우, 상하
			copyMap(temp, map);
			view(map, dx, dy, 3);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 2);
			tv(cnt + 1, map);

		} else if (arr[dx][dy] == 3) {
			// 상우, 상좌, 하우, 하좌
			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 3);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 2);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 2);
			view(map, dx, dy, 3);
			tv(cnt + 1, map);

		} else if (arr[dx][dy] == 4) {
			// 상우하, 우하좌, 하좌상, 좌상우
			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 2);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 2);
			view(map, dx, dy, 3);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 2);
			view(map, dx, dy, 3);
			tv(cnt + 1, map);

			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 3);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);
		} else if (arr[dx][dy] == 5) {
			// 상하좌우
			copyMap(temp, map);
			view(map, dx, dy, 1);
			view(map, dx, dy, 2);
			view(map, dx, dy, 3);
			view(map, dx, dy, 4);
			tv(cnt + 1, map);
		}
	}

	private static void view(int[][] result, int x, int y, int k) {
		if (k == 1) { // 상
			for (int i = x - 1; i >= 0; i--) {
				if (result[i][y] == 6)
					break;
				if (result[i][y] == 0)
					result[i][y] = -1;
			}
		}
		if (k == 2) { // 하
			for (int i = x + 1; i < N; i++) {
				if (result[i][y] == 6)
					break;
				if (result[i][y] == 0)
					result[i][y] = -1;
			}
		}
		if (k == 3) { // 좌
			for (int j = y - 1; j >= 0; j--) {
				if (result[x][j] == 6)
					break;
				if (result[x][j] == 0)
					result[x][j] = -1;
			}
		}
		if (k == 4) { // 우
			for (int j = y + 1; j < M; j++) {
				if (result[x][j] == 6)
					break;
				if (result[x][j] == 0)
					result[x][j] = -1;
			}
		}
	}

	private static void copyMap(int[][] arr2, int[][] result2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result2[i][j] = arr2[i][j];
			}
		}
	}

	private static int count(int[][] arr) {
		int c = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					c++;
				}
			}
		}

		return c;
	}

}
