import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int cnt = 0;
			int ans = 0;
			String str = br.readLine();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) == 'O') {
					cnt++;
					ans += cnt;
				} else if(str.charAt(i)=='X') {
					cnt = 0;
				}
			}
			System.out.println(ans);
		}
	}

}
