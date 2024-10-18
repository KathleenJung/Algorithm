import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replaceAll("c=", "*");
        str = str.replaceAll("c-", "*");
        str = str.replaceAll("dz=", "*");
        str = str.replaceAll("d-", "*");
        str = str.replaceAll("lj", "*");
        str = str.replaceAll("nj", "*");
        str = str.replaceAll("s=", "*");
        str = str.replaceAll("z=", "*");

        System.out.println(str.length());
    }
}
