import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//	1767. [SW Test 샘플문제] 프로세서 연결하기
public class Solution_1767 {
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
	static boolean[][] visited;
	static int max;
	static List<Point> list;
	static int count;
	static int line;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<>();
			count = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						visited[i][j] = true;
						if (i != 0 && j != 0) {
							list.add(new Point(i, j));
						} else if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
							count++;
						}
					}
				}
			}
			max = 0;
			line = Integer.MAX_VALUE;

			solve();

			System.out.println("#" + (t + 1) + " " + line);
		}
	}

	private static void solve() {
		dfs(0, count);
	}

	private static void dfs(int index, int cnt) {
		if (index == list.size()) {
			return;
		}

		if (max < cnt) {
			max = cnt;
			line = line();
		} else if (max == cnt) {
			line = Math.min(line, line());
		}
		dfs(index + 1, cnt);

		Point p = list.get(index);

		boolean[] connect = new boolean[4];

		/* 상 */
		connect[0] = true;
		// 위로 연결할 수 있는지 확인
		for (int i = 0; i < p.x; i++) {
			if (visited[i][p.y] == true) {
				connect[0] = false;
				break;
			}
		}
		// 위로 연결하기
		if (connect[0] == true) {
			// 연결하기
			for (int i = 0; i < p.x; i++) {
				visited[i][p.y] = true;
			}
			if (max < cnt + 1) {
				max = cnt + 1;
				line = line();
			} else if (max == cnt + 1) {
				line = Math.min(line, line());
			}
			dfs(index + 1, cnt + 1);

			// 롤백
			for (int i = 0; i < p.x; i++) {
				visited[i][p.y] = false;
			}
		}

		/* 하 */
		connect[1] = true;
		for (int i = p.x + 1; i < N; i++) {
			if (visited[i][p.y] == true) {
				connect[1] = false;
				break;
			}
		}
		if (connect[1] == true) {
			// 연결하기
			for (int i = p.x + 1; i < N; i++) {
				visited[i][p.y] = true;
			}
			if (max < cnt + 1) {
				max = cnt + 1;
				line = line();
			} else if (max == cnt + 1) {
				line = Math.min(line, line());
			}
			dfs(index + 1, cnt + 1);
			// 롤백
			for (int i = p.x + 1; i < N; i++) {
				visited[i][p.y] = false;
			}
		}

		/* 좌 */
		connect[2] = true;
		for (int i = 0; i < p.y; i++) {
			if (visited[p.x][i] == true) {
				connect[2] = false;
				break;
			}
		}
		if (connect[2] == true) {
			// 연결하기
			for (int i = 0; i < p.y; i++) {
				visited[p.x][i] = true;
			}
			if (max < cnt + 1) {
				max = cnt + 1;
				line = line();
			} else if (max == cnt + 1) {
				line = Math.min(line, line());
			}
			dfs(index + 1, cnt + 1);
			// 롤백
			for (int i = 0; i < p.y; i++) {
				visited[p.x][i] = false;
			}
		}

		/* 우 */
		connect[3] = true;
		for (int i = p.y + 1; i < N; i++) {
			if (visited[p.x][i] == true) {
				connect[3] = false;
				break;
			}
		}

		if (connect[3] == true) {
			// 연결하기
			for (int i = p.y + 1; i < N; i++) {
				visited[p.x][i] = true;
			}
			if (max < cnt + 1) {
				max = cnt + 1;
				line = line();
			} else if (max == cnt + 1) {
				line = Math.min(line, line());
			}
			dfs(index + 1, cnt + 1);
			// 롤백
			for (int i = p.y + 1; i < N; i++) {
				visited[p.x][i] = false;
			}
		}

	}

	private static int line() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == true) {
					cnt++;
				}
			}
		}

//		System.out.println(cnt + " " + list.size() + " " + count);

		// 모든 visited 배열 개수 - 연결되지 않은 코어 수 - 연결할 필요가 없는 코어 수
		return cnt - list.size() - count;
	}

}
