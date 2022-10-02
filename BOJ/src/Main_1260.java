
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
	static int N;
	static int M;
	static int V;
	static boolean[][] arr;
	static boolean[] visited;
	static Queue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		visited = new boolean[N + 1];

		q = new ArrayDeque<>();

		arr = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = true;
			arr[y][x] = true;
		}

//		for (int i = 0; i < N + 1; i++) {
//			for (int j = 0; j < N + 1; j++) {
//				System.out.print(arr[i][j] == true ? 1 : 0);
//			}
//			System.out.println();
//		}

		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		System.out.println();

		sc.close();
	}

	private static void bfs(int v) {
		q.offer(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int p = q.poll();
			System.out.print(p + " "); 
			for (int i = 1; i <= N; i++) {
				if(arr[p][i] && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i <= N; i++) {
			if(arr[v][i] && !visited[i]) {
				dfs(i);
			}
		}
	}
}
