import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double subject = 0;

        for(int i=0;i<20;i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");
            if(!arr[2].equals("P")) {
                subject += Double.parseDouble(arr[1]);
                if(arr[2].equals("A+")) {
                    sum += 4.5 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("A0")) {
                    sum += 4.0 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("B+")) {
                    sum += 3.5 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("B0")) {
                    sum += 3.0 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("C+")) {
                    sum += 2.5 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("C0")) {
                    sum += 2.0 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("D+")) {
                    sum += 1.5 * Double.parseDouble(arr[1]);
                } else if(arr[2].equals("D0")) {
                    sum += Double.parseDouble(arr[1]);
                }
            }
        }

        System.out.printf("%.6f", sum / subject);
    }
}
