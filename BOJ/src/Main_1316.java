import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            if(solution(str)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean solution(String str) {
        boolean[] arr = new boolean[26];
        char prev = '-';
        for(int i=0;i<str.length();i++) {
            if(prev != str.charAt(i)) {
                if(arr[str.charAt(i)-'a']) {
                    return false;
                }
                arr[str.charAt(i)-'a'] = true;
                prev = str.charAt(i);
            }
        }
        return true;
    }
}
