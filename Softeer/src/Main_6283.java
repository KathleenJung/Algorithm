import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr));
    }

    public static String solution(int[] arr) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 7; i++) {
            if (arr[i] < arr[i + 1]) {
                descending = false;
            } else if (arr[i] > arr[i + 1]) {
                ascending = false;
            }
        }

        if (ascending) {
            return "ascending";
        } else if (descending) {
            return "descending";
        } else {
            return "mixed";
        }
    }
}