import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1949 {
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N, K;
	static int[][] map;
	static Queue<Point> q;
	static int maxLength;
	static int max;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			max = 0;
			q = new ArrayDeque<>();
			maxLength = 0;
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k <= K; k++) {
						solve(i, j, k);
					}
				}
			}
			
			System.out.println("#" + (t+1) + " " + maxLength);
		}
	}
	private static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void solve(int x, int y, int k) {
		max = 0;
		q = new ArrayDeque<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]>max) {
					max = map[i][j];
				}
			}
		}
		
		map[x][y] -= k;
		
//		printMap();
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]>=max) {
					q.offer(new Point(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int length = 1;
			dfs(p.x, p.y, length);
		}
		
		map[x][y] += k;
	}
	private static void dfs(int x, int y, int length) {
		for (int d = 0; d < 4; d++) {
			int dx = x + delta[d][0];
			int dy = y + delta[d][1];
			
			if(dx>=0&&dy>=0&&dx<N&&dy<N&&map[dx][dy]<map[x][y]) {
				dfs(dx, dy, length + 1);
			}
		}
		if(length>maxLength) {
			maxLength = length;
		}
	}

}
