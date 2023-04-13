import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i)-'0'-49);
			if (arr[str.charAt(i) - '0' - 49] == 0) {
				arr[str.charAt(i) - '0' - 49] = i + 1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] == 0 ? "-1 " : arr[i] - 1 + " ");
		}
	}

}
