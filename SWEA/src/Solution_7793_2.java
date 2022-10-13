import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_2 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N, M;
	static char[][] map;
	static Queue<Point> devil;
	static Queue<Point> suyeon;
	static boolean[][] visited;
	static boolean[][] visitedS;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static int time;
	static boolean isPossible;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			devil = new ArrayDeque<>();
			suyeon = new ArrayDeque<>();
			time = 0;
			isPossible = false;
			visited = new boolean[N][M];
			visitedS = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						visited[i][j] = true;
						devil.offer(new Point(i, j));
					}
					else if(map[i][j] == 'S') {
						visitedS[i][j] = true;
						suyeon.offer(new Point(i, j));
					}
				}
			}
			
			solve();
			
			System.out.print("#" + (t+1) + " ");
			if(isPossible == true) {
				System.out.print(time + "\n");
			} else {
				System.out.print("GAME OVER" + "\n");
			}
		}
	}
	private static void solve() {
		while(!suyeon.isEmpty()) {
			time++;
			int size = devil.size();
			for (int s = 0; s < size; s++) {
				Point p = devil.poll();
				for (int d = 0; d < 4; d++) {
					int dx = p.x + delta[d][0];
					int dy = p.y + delta[d][1];
					
					if(dx>=0&&dy>=0&&dx<N&&dy<M&&!visited[dx][dy]&&map[dx][dy]!='X'&&map[dx][dy]!='D') {
						visited[dx][dy] = true;
						devil.offer(new Point(dx, dy));
					}
				}
			}
			
			size = suyeon.size();
			for (int s = 0; s < size; s++) {
				Point su = suyeon.poll();
				for (int d = 0; d < 4; d++) {
					int dx = su.x + delta[d][0];
					int dy = su.y + delta[d][1];
					
					if(dx>=0&&dy>=0&&dx<N&&dy<M&&!visited[dx][dy]&&map[dx][dy]!='X') {
						if(map[dx][dy] == 'D') {
							isPossible = true;
							return;
						}
						visitedS[dx][dy] = true;
						suyeon.offer(new Point(dx, dy));
					}
				}
			}
		}
	}

}
