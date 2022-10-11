import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3184 {
	static int R, C;
	static char[][] map;
	static int sheep, wolf, s, w;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		sheep = 0;
		wolf = 0;

		// #:울타리, o:양, v:늑대
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
//		for (int r = 0; r < R; r++) {
//			for (int c = 0; c < C; c++) {
//				System.out.print(map[r][c]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] != '#' && !visited[r][c]) {
					visited[r][c] = true;
					w = 0;
					s = 0;
					dfs(r, c);
					if(w>=s) {
						wolf += w;
					}
					else if(s>w) {
						sheep += s;
					}
				}
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}
	private static void dfs(int x, int y) {
		if(map[x][y] == 'v') {
			w++;
		}
		else if(map[x][y]=='o') {
			s++;
		}
		for (int d = 0; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			if(nx>=0&&ny>=0&&nx<R&&ny<C&&!visited[nx][ny]&&map[nx][ny]!='#') {
				visited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}

}
