import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("");
        Arrays.sort(strArr, Comparator.reverseOrder());
        for(int i=0;i<strArr.length;i++) {
            System.out.print(strArr[i]);
        }
    }
}
