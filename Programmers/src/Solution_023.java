// Programmers [코딩테스트 입문] 023. 문자열 뒤집기

public class Solution_023 {

	public static void main(String[] args) {
		System.out.println(solution("jaron"));
		System.out.println(solution("bread"));
	}

	public static String solution(String my_string) {
		String answer = "";
		for (int i = 0; i < my_string.length(); i++) {
			answer += my_string.charAt(my_string.length() - 1 - i);
		}
		return answer;
	}

}
