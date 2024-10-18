import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        int max = 0;
        char maxChar = '-';
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++) {
            arr[str.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxChar = (char) (i+'a');
            } else if (max == arr[i]) {
                maxChar = '?';
            }
        }
        System.out.println(Character.toUpperCase(maxChar));
    }
}