import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2112 {
	static int D, W, K; // 두께, 가로, 합격 기준
	static int[][] map;
	static boolean[] visited;
	static boolean pass;
	static int min;
	static int[][] copyMap;
	static ArrayList<Integer> truelist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			copyMap = new int[D][W];
			pass = false;
			min = 0;
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int c = 0; c <= D; c++) {
				visited = new boolean[D];
				comb(0, 0, c);
				if (pass == true) {
					break;
				}
			}
			System.out.println("#" + (t + 1) + " " + min);
		}
	}

	private static void comb(int cnt, int pos, int c) {
		if (cnt == c) {
			truelist = new ArrayList<>();
			for (int i = 0; i < D; i++) {
//				System.out.print(visited[i] ? i + " " : "");
				if (visited[i]) {
					truelist.add(i);
				}
			}
//			System.out.println();
			chemical();
			if (pass == true) {
				min = cnt;
				return;
			}
			return;
		}
		for (int i = pos; i < D; i++) {
			visited[i] = true;
			comb(cnt + 1, i + 1, c);
			visited[i] = false;
		}
	}

	private static void dfs(int pos) {
		if (pos == truelist.size()) {
			check();
			return;
		}

		for (int j = 0; j < W; j++) {
			copyMap[truelist.get(pos)][j] = 0;
		}
		dfs(pos+1);
		for (int j = 0; j < W; j++) {
			copyMap[truelist.get(pos)][j] = 1;
		}
		dfs(pos+1);
	}

	private static void chemical() {
		copy(map, copyMap);
		dfs(0);
	}

	private static void copy(int[][] map, int[][] copyMap) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	private static void check() {
//		printMap();
		for (int i = 0; i < W; i++) {
			int cnt = 0;
			int c = copyMap[0][i];
			for (int j = 0; j < D; j++) {
				if (c != copyMap[j][i]) {
					c = copyMap[j][i];
					cnt = 1;
				} else {
					cnt++;
				}
				if (cnt == K) {
					break;
				}
			}
			if (cnt < K) {
				return;
			}
		}
		pass = true;
		return;
	}

	private static void printMap() {
		System.out.println("▼▼▼ Print ▼▼▼");
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(copyMap[i][j] + " ");
			}
			System.out.println();
		}
	}

}
