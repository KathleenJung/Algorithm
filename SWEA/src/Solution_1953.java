import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_1953 {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, R, C, L; // N 세로, 가로 M, 맨홀세로R, 맨홀가로C, 탈출소요시간L
	static int[][] map;
	static boolean[][] visited;
	static Stack<Point> stack;
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			bfs(R, C);
//			for (int sta = 0; sta < stack.size(); sta++) {
//				System.out.println("x= "+stack.get(sta).x);
//				System.out.println("y= "+stack.get(sta).y);
//				System.out.println();
//			}

			sb.append("#").append(t+1).append(" ")
			.append(stack.size()).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int r, int c) {
		int cnt = 0;
		q = new ArrayDeque<>();
		stack = new Stack<>();
		q.offer(new Point(r, c));
		visited = new boolean[N][M];
		visited[r][c] = true;
		stack.push(new Point(r, c));
		while (!q.isEmpty()) {
			if (cnt >= L-1) {
				return;
			}
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point temp;
				temp = q.poll();
				
				if(map[temp.x][temp.y] == 1) {
					up(temp.x, temp.y);
					down(temp.x, temp.y);
					left(temp.x, temp.y);
					right(temp.x, temp.y);
				} else if(map[temp.x][temp.y] == 2) {
					up(temp.x, temp.y);
					down(temp.x, temp.y);
				} else if(map[temp.x][temp.y] == 3) {
					left(temp.x, temp.y);
					right(temp.x, temp.y);
				} else if(map[temp.x][temp.y] == 4) {
					up(temp.x, temp.y);
					right(temp.x, temp.y);
				} else if(map[temp.x][temp.y] == 5) {
					right(temp.x, temp.y);
					down(temp.x, temp.y);
				} else if(map[temp.x][temp.y] == 6) {
					left(temp.x, temp.y);
					down(temp.x, temp.y);
				} else if(map[temp.x][temp.y] == 7) {
					left(temp.x, temp.y);
					up(temp.x, temp.y);
				}
			}
			cnt++;
		}
	}
	
	static void up(int x, int y) {
		int nx = x - 1;
		int ny = y;
		if (nx >= 0 && ny >= 0 && nx < N && ny < M
				&& !visited[nx][ny] && (map[nx][ny] == 1
				|| map[nx][ny] == 2
				|| map[nx][ny] == 5 || map[nx][ny] == 6)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));
			stack.push(new Point(nx, ny));
		}
	}
	
	static void down(int x, int y) {
		int nx = x + 1;
		int ny = y;
		if (nx >= 0 && ny >= 0 && nx < N && ny < M
				&& !visited[nx][ny] && (map[nx][ny] == 1
				|| map[nx][ny] == 2
				|| map[nx][ny] == 4 || map[nx][ny] == 7)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));
			stack.push(new Point(nx, ny));
		}
	}
	
	static void left(int x, int y) {
		int nx = x;
		int ny = y - 1;
		if (nx >= 0 && ny >= 0 && nx < N && ny < M
				&& !visited[nx][ny] && (map[nx][ny] == 1
				|| map[nx][ny] == 3
				|| map[nx][ny] == 4 || map[nx][ny] == 5)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));
			stack.push(new Point(nx, ny));
//			System.out.println(temp.x+" "+temp.y+" "+nx+" "+ny+" "+map[nx][ny]);
		}
	}
	
	static void right(int x, int y) {
		int nx = x;
		int ny = y + 1;
		if (nx >= 0 && ny >= 0 && nx < N && ny < M
				&& !visited[nx][ny] && (map[nx][ny] == 1
				|| map[nx][ny] == 3
				|| map[nx][ny] == 6 || map[nx][ny] == 7)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));
			stack.push(new Point(nx, ny));
//			System.out.println(temp.x+" "+temp.y+" "+nx+" "+ny+" "+map[nx][ny]);
		}
	}

}
