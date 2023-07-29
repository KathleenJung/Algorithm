import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            map.put(arr[0], arr[1]);
        }

        for (int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
