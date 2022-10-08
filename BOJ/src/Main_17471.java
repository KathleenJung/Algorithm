import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {
	static boolean[][] isConnected;
	static int[] amount;
	static int N;
	static boolean[] isSelected;
	static int a, b, min;
	static boolean[] check;
	static List<Integer> listA;
	static List<Integer> listB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isConnected = new boolean[N + 1][N + 1];
		isSelected = new boolean[N + 1];
		amount = new int[N + 1];
		min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			amount[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
//			System.out.println(str);
			for (int j = 2; j < str.length(); j++) {
				int temp = (int) str.charAt(j) - '0';
//				System.out.println(temp);
				isConnected[i][temp] = true;
				isConnected[temp][i] = true;
				j++;
			}
		}

//		for (int i = 0; i < N + 1; i++) {
//			for (int j = 0; j < N + 1; j++) {
//				System.out.print(isConnected[i][j] == true ? 1 + " " : 0 + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		subset(0);
		
		if(min!=Integer.MAX_VALUE) {
		System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
	}

	private static void subset(int idx) {
		if (idx == N + 1) {
			a = b = 0;
			if (connectCheck(isSelected)) {
				for (int i = 1; i <= N; i++) {
//					System.out.print(isSelected[i] ? i : "X");
//					System.out.print(" ");
					if (isSelected[i]) {
						a += amount[i];
					} else {
						b += amount[i];
					}
				}
//				System.out.println();
				min = Math.min(Math.abs(a - b), min);
			}
			return;
		}

		isSelected[idx] = true;
		subset(idx + 1);
		isSelected[idx] = false;
		subset(idx + 1);
	}

	private static boolean connectCheck(boolean[] isSelected2) {
		listA = new ArrayList<>();
		listB = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (isSelected2[i] == true) {
				listA.add(i);
			} else if (isSelected2[i] == false) {
				listB.add(i);
			}
		}
		if (listA.size() != N && listB.size() != N) {
//			System.out.println(listA.toString());
//			System.out.println(listB.toString());

			int aa = listA.get(0);
			int bb = listB.get(0);

			if (bfs(aa, listA) && bfs(bb, listB)) {
				return true;
			}
		}

		return false;
	}

	private static boolean bfs(int temp, List<Integer> arrayList) {
//		System.out.println();
//		System.out.println("temp : " + temp);
//		for(int i : arrayList)
//			System.out.print(i + "             ");
//		System.out.println();
		
		check = new boolean[N + 1];

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(temp);
		check[temp] = true;
		
		while (!q.isEmpty()) {
			int t = q.poll();
			for (int i = 1; i <= N; i++) {
				if (arrayList.contains(i) && isConnected[i][t] && !check[i]) {
					check[i] = true;
					q.offer(i);
				}
			}
		}

		for(int i = 0; i < arrayList.size(); i++) {
			if(!check[arrayList.get(i)])
				return false;
		}
		
		return true;
	}
}