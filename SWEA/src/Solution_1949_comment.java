import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 1949. [모의 SW 역량테스트] 등산로 조성
public class Solution_1949_comment {
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	// N*N의 지도, 최대 공사 가능 깊이 K
	static int N, K;
	// 등산로 부지를 저장할 배열 map
	static int[][] map;
	// BFS 탐색을 위한 Queue
	static Queue<Point> q;
	// 가장 긴 등산로의 길이
	static int maxLength;
	// 가장 높은 봉우리의 높이
	static int max;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 지도의 가로 세로 크기 N
			N = Integer.parseInt(st.nextToken());
			// 최대 공사 가능 깊이
			K = Integer.parseInt(st.nextToken());
			
			// 전역 변수 초기화
			map = new int[N][N];
			max = 0;
			q = new ArrayDeque<>();
			maxLength = 0;
			
			// 등산로 부지 정보 입력
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

	// map[x][y]의 높이를 k만큼 깎음
	private static void solve(int x, int y, int k) {
		max = 0;
		q = new ArrayDeque<>();

		// 모든 좌표를 탐색
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				// 가장 높은 봉우리 높이인 max 값 찾기 (등산로 시작 점)
				if(map[i][j]>max) {
					max = map[i][j];
				}
			}
		}
		
		// k만큼 지형 깎기
		map[x][y] -= k;
		
		// 모든 좌표를 탐색
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				// 등산로의 시작점이 될 수 있는 좌표(가장 높은 봉우리)라면 모두 queue에 넣기
				if(map[i][j]==max) {
					q.offer(new Point(i, j));
				}
			}
		}
		

		// Queue에 담긴 등산로의 시작점들을 모두 dfs 탐색하여 등산로 길이 계산하기
		while(!q.isEmpty()) {
			Point p = q.poll();
			int length = 1;
			dfs(p.x, p.y, length);
		}
		
		// 다음 탐색을 위하여 깎은 등산로 원상복구
		map[x][y] += k;
	}
	
	
	private static void dfs(int x, int y, int length) {

		// 1. 가로 또는 세로 방향 조건을 위해 delta를 이용한 사방탐색
		for (int d = 0; d < 4; d++) {
			int dx = x + delta[d][0];
			int dy = y + delta[d][1];
			
			// 2. map[dx][dy] < map[x][y] 조건으로
			// 높은 지형에서 낮은 지형으로만 가는 조건만 탐색
			if(dx>=0&&dy>=0&&dx<N&&dy<N&&map[dx][dy]<map[x][y]) {
				dfs(dx, dy, length + 1);
			}
		}
		
		// 현재 등산로의 높이가 maxLength보다 크다면 갱신
		if(length>maxLength) {
			maxLength = length;
		}
	}

}
