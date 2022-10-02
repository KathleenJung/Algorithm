import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247 {

	static int[] office;
	static int[] home;
	static int[][] client;
	static int ans;
	static int[] numbers;
	static int N;
	static int min;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			ans = 0;
			min = Integer.MAX_VALUE;
			office = new int[2];
			home = new int[2];
			client = new int[N][2];
			numbers = new int[N];
			visited = new boolean[N];

			office[0] = Integer.parseInt(st.nextToken());
			office[1] = Integer.parseInt(st.nextToken());

			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			for(int i=0;i<N;i++) {
				client[i][0] = Integer.parseInt(st.nextToken());
				client[i][1] = Integer.parseInt(st.nextToken());
			}

			process(0,0);

			sb.append("#").append(t+1).append(" ").append(min).append("\n");

		}
		System.out.println(sb);
	}

	public static void process(int cnt, int idx) {
		if(cnt == N) {
			int sum = 0;
			sum +=
					Math.abs(office[0] - client[numbers[0]][0])
					+ Math.abs(office[1] - client[numbers[0]][1]);
			for(int i=1;i<N;i++) {
				sum +=
						Math.abs(client[numbers[i]][0] - client[numbers[i-1]][0])
						+ Math.abs(client[numbers[i]][1] - client[numbers[i-1]][1]);
			}
			sum +=
					Math.abs(home[0] - client[numbers[N-1]][0])
					+ Math.abs(home[1] - client[numbers[N-1]][1]);
			min = Math.min(min, sum);
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				numbers[idx] = i;
				process(cnt+1, idx+1);
				visited[i] = false;
			}
		}
	}
}