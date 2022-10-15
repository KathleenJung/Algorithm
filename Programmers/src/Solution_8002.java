import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8002 {
	// 8) 깊이/너비 우선 탐색(DFS/BFS) > 2.네트워크
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < map.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(solution(N, map));
//		cnt = 0;
//		for (int i = 1; i < map.length; i++) {
//			if (!visited[i]) {
//				cnt++;
//				visited[i] = true;
//				dfs(i);
//			}
//		}
//		System.out.println(cnt);
	}
	
	public static int solution(int n, int[][] computers) {
        cnt = 0;
        for (int i = 0; i < map.length; i++) {
			if (!visited[i]) {
				cnt++;
				visited[i] = true;
				dfs(i);
			}
		}
        return cnt;
    }

	private static void dfs(int x) {
//		for (int i = 0; i < map.length; i++) {
//			System.out.print(visited[i] == true ? 1 : 0);
//		}
//		System.out.println();
		for (int i = 0; i < map.length; i++) {
			if (map[x][i] == 1 && !visited[i]) {
//				System.out.println(cnt);
//				System.out.println(x + " " + i);
				visited[i] = true;
				dfs(i);
			}
		}
	}

}
