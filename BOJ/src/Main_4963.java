import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			if(w == 0 && h == 0) {
				break;
			}
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						cnt++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}

//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(visited[i][j]==true?1:0);
//				}
//				System.out.println();
//			}
//			System.out.println();
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	private static void dfs(int x, int y) {
		for (int d = 0; d < 8; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			if(nx>=0&&ny>=0&&nx<h&&ny<w&&!visited[nx][ny]&&map[nx][ny]==1) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

}
