import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5212 {
	static int N;
	static int L;
	static int[][] map;
	static boolean[] selected;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][2];
			max = 0;
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
//				[0] = 맛에 대한 점수, [1] = 칼로리
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			subset(0,0);
			System.out.println("#" + (t+1) + " " + max);
		}
	}
	private static void subset(int cnt, int pos) {
		if(pos == N) {
			int mat = 0;
			int cal = 0;
			for (int i = 0; i < N; i++) {
//				System.out.print(selected[i] == true?i:" ");
				if(selected[i]) {
					mat += map[i][0];
					cal += map[i][1];
				}
			}
//			System.out.println();
			if(cal <= L) {
				max = Math.max(mat, max);
			}
			
			return;
		}
		
		selected[pos] = true;
		subset(cnt+1, pos+1);
		selected[pos] = false;
		subset(cnt, pos+1);
	}
}
