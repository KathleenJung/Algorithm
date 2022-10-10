import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653 {
	static class Point {
		int x;
		int y;
		int time;
		int amount;
		boolean active;

		public Point(int x, int y, int time, int amount, boolean alive) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.amount = amount;
			this.active = alive;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", time=" + time + ", amount=" + amount + ", active=" + active + "]";
		}

	}

	static int N, M, K;
	static int[][] map;
	static Queue<Point> q;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N + 300][N + 300];
			q = new ArrayDeque<>();

			for (int i = 150; i < 150 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 150; j < 150 + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0) {
						q.offer(new Point(i, j, map[i][j], map[i][j], false));
					}
				}
			}

			solve();

			System.out.println("#" + (t + 1) + " " + q.size());
		}
	}

	private static void solve() {
		int time = 0;
		int[][] tempMap = new int[N + 300][N + 300];
		for (int i = 0; i < tempMap.length; i++) {
			for (int j = 0; j < tempMap.length; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		while (time < K) {
			int size = q.size();
//			System.out.println(time + "시간 뒤 : q 사이즈는  " + q.size() + " " + q.toString());
			for (int i = 0; i < size; i++) {
				Point p = q.poll();
				p.time--;

				// 비활성화 상태
				if (p.active == false) {
					// 비활성화 상태 + 타임이 0이면 세포 활성화 시킴
					if (p.time == 0) {
						q.offer(new Point(p.x, p.y, p.amount, p.amount, true));
					}
					// 비활성화 상태 + 타임이 0이 아니면 아직 세포 활성화 시키지 않음
					else if (p.time != 0) {
						q.offer(new Point(p.x, p.y, p.time, p.amount, false));
					}
				}
				// 활성화 상태
				else if (p.active == true) {
					// 활성화 상태 되고, 1시간 후 번식
					if (p.time == p.amount - 1) {

						// 활성 상태 상,하,좌,우 번식
						for (int d = 0; d < 4; d++) {
							int dx = p.x + delta[d][0];
							int dy = p.y + delta[d][1];
							if ((tempMap[dx][dy] >= 100 && tempMap[dx][dy] < p.amount * 100) || tempMap[dx][dy] == 0) {
								tempMap[dx][dy] = p.amount * 100;
							}
						}
					}
					// 활성화 상태 + 타임이 0이 아니면
					if (p.time != 0) {
						q.offer(new Point(p.x, p.y, p.time, p.amount, true));
					}
					// 활성화 상태 + 타임 0
					else if (p.time == 0) {
						continue;
					}
				}
			}
//			print(tempMap);
			for (int r = 0; r < tempMap.length; r++) {
				for (int c = 0; c < tempMap.length; c++) {
					if (tempMap[r][c] >= 100) {
						map[r][c] = tempMap[r][c] / 100;
						tempMap[r][c] /= 100;
						q.offer(new Point(r, c, tempMap[r][c], tempMap[r][c], false));
					}
				}
			}
			time++;
		}
	}

	private static void print(int[][] tempMap) {
		for (int i = 140; i < 160; i++) {
			for (int j = 140; j < 160; j++) {
				System.out.print(tempMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
