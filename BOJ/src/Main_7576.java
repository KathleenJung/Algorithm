import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7576 {
	static int M, N;
	static int[][] arr;
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		cnt = 0;
		tomato();
		System.out.println(cnt);
	}
	private static void tomato() {
		while(!check()) {
			cnt++;
			System.out.println("day + " + cnt);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 1) {
						for (int d = 0; d < 4; d++) {
							int nx = i + delta[d][0];
							int ny = j + delta[d][1];
							if(nx>=0&&ny>=0&&nx<N&&ny<M&&arr[nx][ny] != -1) {
								arr[nx][ny] = 1;
							}
						}
					}
				}
			}
		}
	}
	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					for (int d = 0; d < 4; d++) {
						int nx = i + delta[d][0];
						int ny = j + delta[d][1];
						if(nx>=0&&ny>=0&&nx<N&&ny<M&&(arr[nx][ny] == 1 || arr[nx][ny] == 0)) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

}
