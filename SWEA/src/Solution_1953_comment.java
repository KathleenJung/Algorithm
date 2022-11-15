import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
// 1953. [모의 SW 역량테스트] 탈주범 검거
public class Solution_1953_comment {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	// N 세로, 가로 M, 맨홀세로R, 맨홀가로C, 탈출소요시간L
	static int N, M, R, C, L;
	static int[][] map;
	// BFS 탐색 시 필요한 visited 배열
	static boolean[][] visited;
	// BFS 탐색 시 필요한 Queue
	static Queue<Point> q;
	// 탈주범이 위치할 수 있는 장소의 개수
	static int escape;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 지하 터널 지도의 세로 크기
			N = Integer.parseInt(st.nextToken());
			// 지하 터널 지도의 가로 크기
			M = Integer.parseInt(st.nextToken());
			// 맨홀 뚜껑의 세로 위치
			R = Integer.parseInt(st.nextToken());
			// 맨홀 뚜껑의 가로 위치
			C = Integer.parseInt(st.nextToken());
			// 탈출 후 소요된 시간 입력
			L = Integer.parseInt(st.nextToken());

			// 전역 변수 초기화
			map = new int[N][M];
			escape = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 맨홀 위치부터 탐색 시작
			bfs(R, C);

			sb.append("#").append(t + 1).append(" ").append(escape).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs(int r, int c) {
		// 탈출 시간
		int cnt = 0;
		q = new ArrayDeque<>();
		q.offer(new Point(r, c));
		
		// BFS 탐색 중복 방지를 위한 visited 배열 초기화
		visited = new boolean[N][M];
		visited[r][c] = true;
		
		// 처음에 맨홀 뚜껑을 통하여 지하 터널로 들어간 위치
		escape++;
		while (!q.isEmpty()) {
			// 탐색 시간이 초과되면 탐색 종료
			// L-1 -> (맨홀에 잠복하는 시간 1시간 빼주기)
			if (cnt >= L-1) {
				return;
			}
			
			// 현재 Queue 사이즈만큼 반복 (queue.offer 후 사이즈가 변해 추가로 poll 하는 것을 방지)
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point temp;
				temp = q.poll();

				// 1번 파이프는 상,하,좌,우에 있는 터널과 연결
				if (map[temp.x][temp.y] == 1) {
					// 상,하,좌,우 탐색
					up(temp.x, temp.y);
					down(temp.x, temp.y);
					left(temp.x, temp.y);
					right(temp.x, temp.y);
				}
				// 2번 파이프는 상,하에 있는 터널과 연결
				else if (map[temp.x][temp.y] == 2) {
					// 상,하 탐색
					up(temp.x, temp.y);
					down(temp.x, temp.y);
				}
				// 3번 파이프는 좌,우에 있는 터널과 연결
				else if (map[temp.x][temp.y] == 3) {
					// 좌,우 탐색
					left(temp.x, temp.y);
					right(temp.x, temp.y);
				}
				// 4번 파이프는 상,우에 있는 터널과 연결
				else if (map[temp.x][temp.y] == 4) {
					// 상,우 탐색
					up(temp.x, temp.y);
					right(temp.x, temp.y);
				}
				// 5번 파이프는 하,우에 있는 터널과 연결
				else if (map[temp.x][temp.y] == 5) {
					// 하,우 탐색
					right(temp.x, temp.y);
					down(temp.x, temp.y);
				}
				// 6번 파이프는 하,좌에 있는 터널과 연결
				else if (map[temp.x][temp.y] == 6) {
					// 하,좌 탐색
					left(temp.x, temp.y);
					down(temp.x, temp.y);
				}
				// 7번 파이프는 상,좌에 있는 터널과 연결
				else if (map[temp.x][temp.y] == 7) {
					// 좌,상 탐색
					left(temp.x, temp.y);
					up(temp.x, temp.y);
				}
			}
			// 탈출 시간 1 증가 시켜주기
			cnt++;
		}
	}

	static void up(int x, int y) {
		// 위로 이동 -> map[x-1][y]
		int nx = x - 1;
		int ny = y;
		
		// 위로 이동한 좌표 nx,ny가 맵 범위 안에 있고, 이미 탐색한 좌표가 아니고,
		// 위로 이동할 수 있게 연결이 되있는 모양의 파이프이면
		if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]
				&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));

			// 탈주범이 위치할 수 있는 장소의 수 하나 증가
			escape++;
		}
	}

	static void down(int x, int y) {
		// 아래로 이동 -> map[x+1][y]
		int nx = x + 1;
		int ny = y;

		// 아래로 이동한 좌표 nx,ny가 맵 범위 안에 있고, 이미 탐색한 좌표가 아니고,
		// 아래로 이동할 수 있게 연결이 돼있는 모양의 파이프이면
		if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]
				&& (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));

			// 탈주범이 위치할 수 있는 장소의 수 하나 증가
			escape++;
		}
	}

	static void left(int x, int y) {
		// 왼쪽으로 이동 -> map[x][y-1]
		int nx = x;
		int ny = y - 1;


		// 왼쪽으로 이동한 좌표 nx,ny가 맵 범위 안에 있고, 이미 탐색한 좌표가 아니고,
		// 왼쪽으로 이동할 수 있게 연결이 돼있는 모양의 파이프이면
		if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]
				&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));

			// 탈주범이 위치할 수 있는 장소의 수 하나 증가
			escape++;
		}
	}

	static void right(int x, int y) {
		// 오른쪽으로 이동 -> map[x][y+1]
		int nx = x;
		int ny = y + 1;


		// 오른쪽으로 이동한 좌표 nx,ny가 맵 범위 안에 있고, 이미 탐색한 좌표가 아니고,
		// 오른쪽으로 이동할 수 있게 연결이 돼있는 모양의 파이프이면
		if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]
				&& (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7)) {
			visited[nx][ny] = true;
			q.offer(new Point(nx, ny));

			// 탈주범이 위치할 수 있는 장소의 수 하나 증가
			escape++;
		}
	}

}
