import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        for(int i=0;i<str.length();i++) {
            if(cnt == 4) {
                break;
            } else if(cnt == 0 && str.charAt(i)=='U') {
                cnt++;
            } else if(cnt == 1 && str.charAt(i)=='C') {
                cnt++;
            } else if(cnt == 2 && str.charAt(i)=='P') {
                cnt++;
            } else if(cnt == 3 && str.charAt(i)=='C') {
                cnt++;
            }
        }
        System.out.println(cnt == 4 ? "I love UCPC" : "I hate UCPC");
    }
}
