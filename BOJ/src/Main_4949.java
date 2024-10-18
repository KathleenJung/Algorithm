import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while(!(str = br.readLine()).equals(".")) {
            System.out.println(solution(str)?"yes":"no");
        }
    }

    private static boolean solution(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else if(str.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if(str.charAt(i) == '[') {
                stack.push('[');
            } else if(str.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
