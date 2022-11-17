import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2754 {
//	B5 학점계산
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		if (str.equals("F")) {
			sb.append("0.0");
		} else {
			if (str.charAt(0) == 'A' && str.charAt(1) != '-') {
				sb.append("4.");
			} else if (str.charAt(0) == 'A' && str.charAt(1) == '-' || str.charAt(0) == 'B' && str.charAt(1) != '-') {
				sb.append("3.");
			} else if (str.charAt(0) == 'B' && str.charAt(1) == '-' || str.charAt(0) == 'C' && str.charAt(1) != '-') {
				sb.append("2.");
			} else if (str.charAt(0) == 'C' && str.charAt(1) == '-' || str.charAt(0) == 'D' && str.charAt(1) != '-') {
				sb.append("1.");
			} else if (str.charAt(0) == 'D' && str.charAt(1) == '-') {
				sb.append("0.");
			}
			if (str.charAt(1) == '+') {
				sb.append("3");
			} else if (str.charAt(1) == '0') {
				sb.append("0");
			} else if (str.charAt(1) == '-') {
				sb.append("7");
			}
		}
		System.out.println(sb);
	}
}
