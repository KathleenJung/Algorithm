import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_2 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, R, C, L;
	static int[][] map;
	static int time;
	static boolean[][] visited;
	static int cnt;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상,우,하,좌
	static Queue<Point> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			q = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			time = 1;
			cnt = 0;
			visited = new boolean[N][M];
			visited[R][C] = true;

			q.offer(new Point(R, C));
			solve();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j] == true) {
						cnt++;
					}
				}
			}
			System.out.println("#" + (t+1) + " " + cnt);
		}
	}

	private static void solve() {
		while (!q.isEmpty()) {

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(visited[i][j] == true ? 1 : 0);
//				}
//				System.out.println();
//			}
//			System.out.println();

			if (time == L) {
				return;
			}
//			System.out.println(time);
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				if (map[p.x][p.y] == 1) {
					for (int d = 0; d < 4; d++) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				} else if (map[p.x][p.y] == 2) {
					for (int d = 0; d < 4; d += 2) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				} else if (map[p.x][p.y] == 3) {
					for (int d = 1; d < 4; d += 2) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				} else if (map[p.x][p.y] == 4) {
					for (int d = 0; d < 2; d++) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				} else if (map[p.x][p.y] == 5) {
					for (int d = 1; d < 3; d++) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				} else if (map[p.x][p.y] == 6) {
					for (int d = 2; d < 4; d++) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				} else if (map[p.x][p.y] == 7) {
					for (int d = 0; d < 4; d += 3) {
						int dx = p.x + delta[d][0];
						int dy = p.y + delta[d][1];
						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visited[dx][dy]) {
							switch (d) {
							case 0:
								up(dx, dy);
								break;
							case 1:
								right(dx, dy);
								break;
							case 2:
								down(dx, dy);
								break;
							case 3:
								left(dx, dy);
								break;
							}
						}
					}
				}
			}
			time++;
		}
	}

	public static void up(int dx, int dy) {
		if (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 5 || map[dx][dy] == 6) {
			visited[dx][dy] = true;
			q.offer(new Point(dx, dy));
		}
	}

	public static void down(int dx, int dy) {
		if (map[dx][dy] == 1 || map[dx][dy] == 2 || map[dx][dy] == 4 || map[dx][dy] == 7) {
			visited[dx][dy] = true;
			q.offer(new Point(dx, dy));
		}
	}

	public static void left(int dx, int dy) {
		if (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 4 || map[dx][dy] == 5) {
			visited[dx][dy] = true;
			q.offer(new Point(dx, dy));
		}
	}

	public static void right(int dx, int dy) {
		if (map[dx][dy] == 1 || map[dx][dy] == 3 || map[dx][dy] == 6 || map[dx][dy] == 7) {
			visited[dx][dy] = true;
			q.offer(new Point(dx, dy));
		}
	}

}
