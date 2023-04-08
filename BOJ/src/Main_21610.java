import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main_21610 {

	static class cloud {
		int x, y;

		public cloud(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int N, M;
	static int[][] map;
	static int[][] move;
	static Queue<cloud> q;
	static int[][] delta = { { -1, -1 }, { 1, -1 }, { 1, 1 }, { -1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		move = new int[M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}

		q = new ArrayDeque<cloud>();
//		비바라기 시전 (N, 1), (N, 2), (N-1, 1), (N-1, 2)
		q.add(new cloud(N - 1, 1 - 1));
		q.add(new cloud(N - 1, 2 - 1));
		q.add(new cloud(N - 1 - 1, 1 - 1));
		q.add(new cloud(N - 1 - 1, 2 - 1));

		for (int i = 0; i < M; i++) {
//			모든 구름이 di 방향으로 si칸 이동
//			System.out.println(i+1 + "트");
//			printCloud();
			moving(move[i][0], move[i][1]);
//			printCloud();
			rain();
//			printMap();
			bug();
			newCloud();
//			System.out.println("완성");
//			printMap();
		}
//		printMap();
		countWater();

	}

	private static void newCloud() {
		int size = q.size();
		int[][] arr = new int[N][N];
		for (int i = 0; i < size; i++) {
			cloud c = q.poll();
			arr[c.x][c.y] = 1;
		}

		q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= 2 && arr[i][j] != 1) {
					map[i][j] -= 2;
					q.offer(new cloud(i, j));
				}
			}
		}
	}

	private static void countWater() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count += map[i][j];
			}
		}
		System.out.println(count);
	}

	private static void bug() {
//		System.out.println("↓ 물 복사 버그 ↓");
		int size = q.size();
		for (int s = 0; s < size; s++) {
			cloud c = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = c.x + delta[d][0];
				int ny = c.y + delta[d][1];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (map[nx][ny] != 0) {
						map[c.x][c.y]++;
					}
				}
			}
			q.offer(c);
		}
//		printMap();
	}

	private static void printMap() {
		System.out.println("↓ 항아리 ↓");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void rain() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			cloud c = q.poll();
			map[c.x][c.y] += 1;
			q.offer(c);
		}
	}

	private static void printCloud() {
		System.out.println("↓ 구름 ↓");
		int size = q.size();
		int[][] arr = new int[N][N];
		for (int i = 0; i < size; i++) {
			cloud c = q.poll();
			arr[c.x][c.y] = 1;
			q.offer(c);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void moving(int m, int amount) {
//		1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
		int size = q.size();
		if (m == 1) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.y -= amount;
				while (c.y < 0) {
					c.y += N;
				}
				q.offer(c);
			}
		} else if (m == 2) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.x -= amount;
				c.y -= amount;
				while (c.x < 0) {
					c.x += N;
				}
				while (c.y < 0) {
					c.y += N;
				}
				q.offer(c);
			}
		} else if (m == 3) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.x -= amount;
				while (c.x < 0 || c.x >= N) {
					c.x += N;
				}
				q.offer(c);
			}
		} else if (m == 4) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.x -= amount;
				while (c.x < 0) {
					c.x += N;
				}
				c.y += amount;
				while (c.y >= N) {
					c.y -= N;
				}
				q.offer(c);
			}
		} else if (m == 5) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.y += amount;
				while (c.y >= N) {
					c.y -= N;
				}
				q.offer(c);
			}
		} else if (m == 6) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.x += amount;
				while (c.x >= N) {
					c.x -= N;
				}
				c.y += amount;
				while (c.y >= N) {
					c.y -= N;
				}
				q.offer(c);
			}
		} else if (m == 7) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.x += amount;
				while (c.x >= N) {
					c.x -= N;
				}
				q.offer(c);
			}
		} else if (m == 8) {
			for (int i = 0; i < size; i++) {
				cloud c = q.poll();
				c.x += amount;
				while (c.x >= N) {
					c.x -= N;
				}
				c.y -= amount;
				while (c.y < 0) {
					c.y += N;
				}
				q.offer(c);
			}
		}
	}

}
