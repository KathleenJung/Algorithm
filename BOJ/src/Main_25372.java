import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25372 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			if(str.length()>=6&&str.length()<=9) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

}
