import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(i, str);
            map2.put(str, i);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if(str.charAt(0) >= 'A' && str.charAt(0) <= 'z') {
                sb.append(map2.get(str)).append("\n");
            } else {
                sb.append(map.get(Integer.parseInt(str))).append("\n");
            }
        }

        System.out.println(sb);
    }
}
