//Programmers [코딩테스트 입문] 032. 가위 바위 보

public class Solution_032 {

	public static void main(String[] args) {
		System.out.println(solution("2"));
		System.out.println(solution("205"));
	}

	public static String solution(String rsp) {
		String answer = "";
		for (int i = 0; i < rsp.length(); i++) {
			if (rsp.charAt(i) == '0') {
				answer += '5';
			} else if (rsp.charAt(i) == '2') {
				answer += '0';
			} else if (rsp.charAt(i) == '5') {
				answer += '2';
			}
		}
		return answer;
	}

}
