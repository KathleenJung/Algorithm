// Programmers [코딩테스트 입문] 028. 특정 문자 제거하기
public class Solution_028 {

	public static void main(String[] args) {
		System.out.println(solution("abcdef", "f"));
		System.out.println(solution("BCBdbe", "B"));
	}

	public static String solution(String my_string, String letter) {
		String answer = "";
		for (int i = 0; i < my_string.length(); i++) {
			if (my_string.charAt(i) != letter.charAt(0)) {
				answer += my_string.charAt(i);
			}
		}
		return answer;
	}

}
