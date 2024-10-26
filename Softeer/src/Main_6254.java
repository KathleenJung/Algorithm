import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Main_6254 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = 0;
        for(int i=0;i<5;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] str1 = st.nextToken().split(":");
            String[] str2 = st.nextToken().split(":");

            LocalTime start = LocalTime.of(Integer.parseInt(str1[0]), Integer.parseInt(str1[1]));
            LocalTime end = LocalTime.of(Integer.parseInt(str2[0]), Integer.parseInt(str2[1]));

            long min = ChronoUnit.MINUTES.between(start, end);
            time += (int) min;
        }
        System.out.println(time);
    }
}
