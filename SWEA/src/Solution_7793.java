import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793 {
	static int N, M;
	static char[][] map;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Point devil, godness, soo;
	static boolean[][] visitedD;
	static boolean[][] visitedS;
	static boolean isPossible;
	static int cnt;
	static Queue<Point> de;

	static class Point {
		int x;
		int y;
		char c;

		public Point(int x, int y, char c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			isPossible = false;
			visitedD = new boolean[N][M];
			visitedS = new boolean[N][M];
			map = new char[N][M];
			cnt = 0;
			de = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
					// 수연이의 위치는 ‘S’, 여신의 공간은 ‘D’, 돌의 위치는 ‘X’, 악마는 ‘*’
					if (map[i][j] == '*') { // 악마
						de.offer(new Point(i, j, 'd'));
						visitedD[i][j] = true;
					} else if (map[i][j] == 'S') { // 수연
						soo = new Point(i, j, 's');
					} else if (map[i][j] == 'D') { // 여신
						godness = new Point(i, j, 'g');
					}
				}
			}

//			printMap();
			solve();
			
//			printVisited(visitedD);
//			printVisited(visitedS);

			System.out.print("#" + (t + 1) + " ");
			System.out.print(isPossible == true ? cnt : "GAME OVER");
			System.out.print("\n");
		}
	}

	private static void printVisited(boolean[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] == true ? 1 + " " : 0 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void solve() {
		Queue<Point> so = new ArrayDeque<>();
		visitedS[soo.x][soo.y] = true;
//		de.offer(devil);
		so.offer(soo);
		while (!so.isEmpty()) {
//			printVisited(visitedD);
//			printVisited(visitedS);
			int size = de.size();
			for (int s = 0; s < size; s++) {
				devil = de.poll();

				for (int d = 0; d < 4; d++) {
					int dx = devil.x + delta[d][0];
					int dy = devil.y + delta[d][1];

					if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 'X' && !visitedD[dx][dy]
							&& map[dx][dy] != 'D') {
//						System.out.println("악마 " + devil.x + " " + devil.y);
//						System.out.println("악마 " + dx + " " + dy);
						visitedD[dx][dy] = true;
						de.offer(new Point(dx, dy, 'd'));
					}
				}
			}
			size = so.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				soo = so.poll();
				for (int d = 0; d < 4; d++) {
					int nx = soo.x + delta[d][0];
					int ny = soo.y + delta[d][1];

					if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
						if (map[nx][ny] == 'D') {
							isPossible = true;
							return;
						}
						if (map[nx][ny] != 'X' && !visitedS[nx][ny] && !visitedD[nx][ny]) {

//						System.out.println("수연 " + soo.x + " " + soo.y);
//						System.out.println("수연 " + nx + " " + ny);
							visitedS[nx][ny] = true;
							so.offer(new Point(nx, ny, 's'));
						}
					}
				}
			}
		}
	}

	private static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
