//	Programmers [코딩테스트 입문] 036. 개미 군단
public class Solution_036 {

	public static void main(String[] args) {
		System.out.println(solution(23));
		System.out.println(solution(24));
		System.out.println(solution(999));
	}

	public static int solution(int hp) {
		int answer = 0;
		answer += hp / 5;
		hp %= 5;
		answer += hp / 3;
		hp %= 3;
		answer += hp;
		return answer;
	}

}
