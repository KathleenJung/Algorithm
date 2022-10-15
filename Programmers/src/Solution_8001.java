import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8001 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		for (int i = 1; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map.length; j++) {
				if (i != j && map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					visited[i][j] = true;
					visited[j][i] = true;
					dfs(i, j);
				}
			}
		}
		System.out.println(cnt);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < map.length; i++) {
			if (map[i][y] == 1 && i != y && !visited[i][y]) {
				System.out.println(cnt);
				System.out.println(i + " " + y);
				visited[i][y] = true;
				visited[y][i] = true;
				dfs(i, y);
			}
		}
	}

}
