import java.util.ArrayDeque;
import java.util.Queue;

// 8) 깊이/너비 우선 탐색(DFS/BFS) > 3. 게임 맵 최단거리
//	Programmers [깊이/너비 우선 탐색(DFS/BFS)] 03. 게임 맵 최단거리
public class Solution_8003 {
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visited;
	static int cnt;
	static int[][] map;
	static Queue<Point> q;

	public static void main(String[] args) {
		int[][] maps = new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		System.out.println(solution(maps));

		maps = new int[][] { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = 0;
		visited = new boolean[maps.length][maps[0].length];
		visited[0][0] = true;
		cnt = 0;
		map = maps;
		bfs();
		answer = cnt;
		return answer;
	}

	public static void bfs() {
		q = new ArrayDeque<>();
		q.offer(new Point(0, 0));

		while (!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();

//				System.out.println(p.x + " " + p.y);

				if (p.x == map.length - 1 && p.y == map[0].length - 1) {
					return;
				}
				for (int d = 0; d < 4; d++) {
					int nx = p.x + delta[d][0];
					int ny = p.y + delta[d][1];
					if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny]
							&& map[nx][ny] == 1) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
		cnt = -1;
	}

}
