import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014 {
	static int N, X;
	static int[][] map;
	static int ans;
	static int impossible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			ans = 0;
			impossible = 0;
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < map.length; i++) {
				solve(i);
			}

			ans = N + N - impossible;

//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map.length; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
//			System.out.println(impossible);

			System.out.println("#" + (t + 1) + " " + ans);
		}
	}

	private static void solve(int i) {
		int l = 1;

		Loop : for (int idx = 0; idx < map.length - 1; idx++) {
//			System.out.println(idx);
			if (map[i][idx] == map[i][idx + 1]) {
				l++;
			}
			// 올라갈 때
			else if (map[i][idx] == map[i][idx + 1] - 1) {
				if (l < X) {
					impossible++;
//					System.out.println(i+"행");
					break;
				} else {
					l = 1;
				}
			}
			// 내려갈 때
			else if (map[i][idx] - 1 == map[i][idx + 1]) {
				for (int j = idx + 1; j < idx + X; j++) {
					if(j+1>=N) {
						impossible++;
//						System.out.println(j);
//						System.out.println(i+"행");
						break Loop;
					}
					if (map[i][j] != map[i][j + 1]) {
						impossible++;
//						System.out.println(i+"행");
						break Loop;
					}
				}
				idx = idx+X-1;
				l = 0;
//				System.out.println("next " + idx);
			}
			else {
				impossible++;
				break Loop;
			}
		}

		l = 1;

		Loop2 : for (int idx = 0; idx < map.length - 1; idx++) {
			if (map[idx][i] == map[idx + 1][i]) {
				l++;
			}
			// 올라갈 때
			else if (map[idx][i] == map[idx + 1][i] - 1) {
				if (l < X) {
//					System.out.println(l);
					impossible++;
//					System.out.println(i+"  열");
					break;
				} else {
					l = 1;
				}
			}
			// 내려갈 때
			else if (map[idx][i] == map[idx + 1][i] + 1) {
				for (int j = idx + 1; j < idx + X; j++) {
					if(j+1>=N) {
						impossible++;
//						System.out.println(i+"열");
						break Loop2;
					}
					if (map[j][i] != map[j + 1][i]) {
						impossible++;
//						System.out.println(i+"열");
						break Loop2;
					}
				}
				idx = idx+X-1;
				l = 0;
			}
			else {
				impossible++;
//				System.out.println(i+"열");
				break Loop2;
			}
		}

	}

}
