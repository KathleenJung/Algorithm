// Programmers [코딩테스트 입문] 020. 옷가게 할인 받기
public class Solution_020 {

	public static void main(String[] args) {
		System.out.println(solution(150000));
		System.out.println(solution(580000));
	}

	public static int solution(int price) {
		int answer = 0;
		if (price >= 500000) {
			answer = price *= 0.8;
		} else if (price >= 300000) {
			answer = price *= 0.9;
		} else if (price >= 100000) {
			answer = price *= 0.95;
		} else {
			answer = price;
		}
		return answer;
	}

}
