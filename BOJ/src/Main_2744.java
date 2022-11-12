import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2744 {
//	B5 대소문자 바꾸기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder str = new StringBuilder();
		str.append(s);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				str.setCharAt(i, (char) (str.charAt(i) + 32));
			} else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				str.setCharAt(i, (char) (str.charAt(i) - 32));
			}
		}
		System.out.println(str);
	}

}
