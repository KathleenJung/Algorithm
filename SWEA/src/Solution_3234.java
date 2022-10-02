import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {

	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			boolean[] visited = new boolean[N];
			ans = 0;
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			scale(0,0,0, visited, arr, N);
			sb.append("#").append(t+1).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static void scale (int cnt, int left, int right, boolean[] visited, int[] arr, int N) {
		if(cnt == N && left>=right) {
			ans++;
			return;
		}
		if(left<right) {
			return;
		}

		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				scale(cnt+1, left+arr[i], right, visited, arr, N);
				scale(cnt+1, left, right+arr[i], visited, arr, N);
				visited[i] = false;
			}
		}
	}

}