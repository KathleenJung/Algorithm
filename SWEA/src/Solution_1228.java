

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=1;t<=10;t++) {
			List<Integer> arr = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int X = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<X;i++) {
				st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				for(int j=0;j<y;j++) {
					int s = Integer.parseInt(st.nextToken());
					arr.add(x+j, s);
				}
			}
			sb.append("#").append(t).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

}
