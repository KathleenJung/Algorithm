import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_14510 {
	static int N;
	static int[] map;
	static int max;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N];
			max = 0;
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i]);
			}
			solve();

			System.out.println("#" + (t + 1) + " " + ans);
		}
	}

	private static void solve() {
		List<Integer> tree = new ArrayList<>();
		for (int i = 0; i < map.length; i++) {
			if (map[i] < max) {
				tree.add(map[i]);
			}
		}
		if(tree.size() == 0) {
			return;
		}
//		for (int i = 0; i < tree.size(); i++) {
//			System.out.print(tree.get(i) + " ");
//		}
//		System.out.println();
		Collections.sort(tree, Collections.reverseOrder());
//		System.out.println(tree.toString());

		water(tree, 1);
	}

	private static void water(List<Integer> tree, int day) {
		// 홀수 날
		if (day % 2 == 1) {
			if (tree.size() != 1) {
				tree.set(0, tree.get(0) + 1);
			}
			// 물 줄게 하나만 남았을 때
			else if (tree.size() == 1) {
				// 딱 2 차이 아닐 때
				if (tree.get(0) != max - 2) {
					tree.set(0, tree.get(0) + 1);
				}
				// 2 차이 날 땐 물 안 주기
			}
		}

		// 짝수 날
		else if (day % 2 == 0) {
			if (tree.size() == 1) {
				// 물 줄게 하나 남았는데 2 이상 차이 날 때 물 주기
				if (tree.get(0) != max - 1) {
					tree.set(0, tree.get(0) + 2);
				}
				// 물 줄게 하나 남았는데 1 차이 날 때 다음날 물 주기
			}

			else if (tree.size() != 1) {
				// 물 줄게 하나가 아닌데 처음꺼가 1 차이 나면 다음꺼 주기
				if (tree.get(0) == max - 1) {
					for (int i = 0; i < tree.size(); i++) {
						if(tree.get(i) < max - 1) {
							tree.set(i, tree.get(i) + 2);
							break;
						}
					}
				}
				// 물 줄게 하나가 아니고 처음꺼가 2 이상 차이 나면 물 주기
				else {
					tree.set(0, tree.get(0) + 2);
				}
			}
		}

//		System.out.println(day + " 일");
//		for (int i = 0; i < tree.size(); i++) {
//			System.out.print(tree.get(i) + " ");
//		}
//		System.out.println();

		Collections.sort(tree, Collections.reverseOrder());

		for (int i = 0; i < tree.size(); i++) {
			if (tree.get(i) == max) {
				tree.remove(i);

				if (tree.size() == 0) {
					ans = day;
					return;
				}
			}
			if (tree.get(i) < max) {
				break;
			}
		}

		water(tree, day + 1);
	}

}
