import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int temp = N / 4;
			String str = br.readLine();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < temp; i++) {
				char c = str.charAt(0);
				str = str.substring(1);
				str += c;
//				System.out.println(str);

				for (int j = 0; j < 4; j++) {
					int ans = Integer.parseInt(str.substring(j * (N / 4), j * (N / 4) + (N / 4)), 16);
					if (!list.contains(ans)) {
						list.add(ans);
					}

				}

				Collections.sort(list, Collections.reverseOrder());

				// temp만큼 끊어서 ArrayList에 넣기 (contains로 확인)
			}

//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i) + " ");
//			}
//			System.out.println();

//			System.out.println(list.get(K-1));
			
			System.out.println("#"+ (t+1) + " " + list.get(K - 1));

		}
	}

}
