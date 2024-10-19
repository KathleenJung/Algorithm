import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(!(str = br.readLine()).equals("0")) {
            System.out.println(isPalindrome(str));
        }
    }

    public static String isPalindrome(String str) {
        for(int i=0;i<str.length()/2;i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return "no";
            }
        }
        return "yes";
    }
}
