import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {

	static int N;
	static char[][] map;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int color, nonColor;
	static char[][] mapRG;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		mapRG = new char[N][N];
		visited = new boolean[N][N];
		color = 0;
		nonColor = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'G' || map[i][j] == 'R') {
					mapRG[i][j] = 'R';
				} else {
					mapRG[i][j] = 'B';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					color++;
					visited[i][j] = true;
//					System.out.println("나는 돌기 전입니다");
//					print();
					dfs(i, j, map[i][j]);
//					System.out.println("나는 돌았습니다");
//					print();
				}
			}
		}
		
		visited = new boolean[N][N];
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(mapRG[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					nonColor++;
					visited[i][j] = true;
//					System.out.println("나는 돌기 전입니다");
//					print();
					dfs2(i, j, mapRG[i][j]);
//					System.out.println("나는 돌았습니다");
//					print();
				}
			}
		}
		System.out.println(color + " " + nonColor);
	}

	private static void dfs(int x, int y, char c) {
		for (int d = 0; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == c) {
				visited[nx][ny] = true;
				dfs(nx, ny, c);
			}
		}
	}
	
	private static void dfs2(int x, int y, char c) {
		for (int d = 0; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && mapRG[nx][ny] == c) {
				visited[nx][ny] = true;
				dfs2(nx, ny, c);
			}
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] ? 1 : 0);
			}
			System.out.println();
		}
		System.out.println();
	}

}
