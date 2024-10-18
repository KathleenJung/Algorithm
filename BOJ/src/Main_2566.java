import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2566 {
    public static void main(String[] args) throws IOException {
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        int[][] arr = new int[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > max) {
                    max = arr[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((maxI+1) + " " + (maxJ+1));
    }
}