//Programmers [코딩테스트 입문] 030. 외계행성의 나이
public class Solution_030 {

	public static void main(String[] args) {
		System.out.println(solution(23));
		System.out.println(solution(51));
		System.out.println(solution(100));
	}

	public static String solution(int age) {
		String answer = "";
		String a = "";
		while (age != 0) {
			int temp = age % 10;
			a += (char) (temp + 'a');
			age /= 10;
		}
		for (int i = a.length() - 1; i >= 0; i--) {
			answer += a.charAt(i);
		}
		return answer;
	}

}
