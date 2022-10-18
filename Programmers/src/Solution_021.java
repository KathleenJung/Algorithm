// Programmers [코딩테스트 입문] 021. 아이스 아메리카노

public class Solution_021 {

	public static void main(String[] args) {
		System.out.println(solution(5500));
		System.out.println(solution(15000));
	}

	public static int[] solution(int money) {
		int[] answer = { 0, 0 };
		answer[0] = money / 5500;
		answer[1] = money % 5500;
		return answer;
	}

}
