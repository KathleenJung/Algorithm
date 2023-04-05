import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int rslt = 1;
		
		for (int i = 0; i < len/2; i++) {
			if(str.charAt(i) != str.charAt(len-i-1)) {
				rslt = 0;
				break;
			}
		}
		
		System.out.println(rslt);
	}

}
