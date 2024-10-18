import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int i=0;i<n;i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            System.out.println(solution(arr)?"YES":"NO");
        }
    }

    private static boolean solution(String[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            if(arr[i+1].startsWith(arr[i])) {
                return false;
            }
        }
        return true;
    }
}
