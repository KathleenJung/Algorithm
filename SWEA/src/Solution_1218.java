

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int t = 1; t <= T; t++)
		{
			int n = Integer.parseInt(br.readLine());
			char[] c= br.readLine().toCharArray();
			int a = 0;
			Stack<Character> s = new Stack<>();
			for(int i=0;i<n;i++) {
				char ch = c[i];
				if(ch==')') {
					if(s.peek() == '(') {
						s.pop();
					}
					else {
						a= 1;
						break;
					}
				}
				else if(ch==']') {
					if(s.peek() == '[') {
						s.pop();
					}
					else {
						a= 1;
						break;
					}
				}
				else if(ch=='}') {
					if(s.peek() == '{') {
						s.pop();
					}
					else {
						a= 1;
						break;
					}			
				}
				else if(ch=='>') {
					if(s.peek() == '<') {
						s.pop();
					}
					else {
						a= 1;
						break;
					}
				}
				else s.push(ch);
			}
			if(s.empty() && a == 0) {
				System.out.println("#"+t+" "+1);
			}
			else {
				System.out.println("#"+t+" "+0);
			}
			
		}

	}
}